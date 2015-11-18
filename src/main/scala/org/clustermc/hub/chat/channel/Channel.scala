package org.clustermc.hub.chat.channel

import java.util.UUID

import org.bukkit.entity.Player
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.permissions.Permission
import org.bukkit.{Bukkit, ChatColor}
import org.clustermc.hub.Hub
import org.clustermc.lib.utils.StringUtil

import scala.collection.JavaConverters._

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class Channel(val name: String, val isPublic: Boolean = false,
              val format: String = "", val prefix: String = "",
              val color: String = s"${ChatColor.GOLD}")
  extends Ordered[Channel] {

  @transient val receivePermission = new Permission(s"social.channel.${name.toLowerCase}.receive")
  @transient val sendPermission = new Permission(s"social.channel.${name.toLowerCase}.send")
  @transient val joinPermission = new Permission(s"social.channel.${name.toLowerCase}.join")

  @transient val members = new collection.mutable.LinkedHashSet[UUID]()

    def prefixOrName = {
        prefix match {
            case "" => name
            case _ => prefix
        }
    }

  def canSend(player: Player): Boolean = isPublic || player.hasPermission(sendPermission)
  def canReceive(player: Player): Boolean = isPublic || player.hasPermission(receivePermission)
  def canJoin(player: Player): Boolean = isPublic || player.hasPermission(joinPermission)

  def join(player: Player) = {
    if(canJoin(player) && !members.contains(player.getUniqueId))
      members.add(player.getUniqueId)
  }

  def leave(uuid: UUID) = {
    if(members.contains(uuid)) members.remove(uuid)
  }

  def commandMessage(player: Player, message: String) = {
    members.foreach((uuid: UUID) => {
      val p = Bukkit.getPlayer(uuid)
      if(p != null && p.isOnline) {
        p.sendMessage(StringUtil.colorString(message))
      }
    })
  }

  def eventMessage(event: AsyncPlayerChatEvent) = {
    event.getRecipients.clear()
    event.getRecipients.addAll(members.flatMap((u: UUID) =>
      Option.apply(Bukkit.getPlayer(u)) match {
        case p: Some[Player] if p.get.isOnline => p
        case _ => None
      }).asJava)
  }

  override def compare(that: Channel): Int = name.compare(that.name)
}

object Channel {
  val channels = new collection.mutable.HashMap[String, Channel]()

  def get(name: String): Option[Channel] = {
    val cOption = channels.get(name.toLowerCase)
    if(cOption.isDefined) cOption
    else {
      for(c <- channels.values)
        if(name.equalsIgnoreCase(c.prefix)) return Option.apply(c)

      None
    }
  }

  //TODO
  def loadChannels(plugin: Hub): Unit = {
    val loaded: Array[Channel] = new ChannelsFile(plugin, "channels").load()
    for(c <- loaded) {
      register(c)
    }
  }

  def register(c: Channel) = channels.put(c.name.toLowerCase, c)
  def unregister(name: String) = if(channels.contains(name)) channels.remove(name)
  def unregister(c: Channel): Unit = this.unregister(c.name.toLowerCase)
}