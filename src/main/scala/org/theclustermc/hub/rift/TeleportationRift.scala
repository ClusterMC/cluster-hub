package org.theclustermc.hub.rift

import java.util.UUID

import org.bukkit.entity.Player
import org.bukkit.{Material, Bukkit, Location}
import org.theclustermc.hub.Hub
import org.theclustermc.hub.bungee.ServerTeleport
import org.theclustermc.hub.utils.cooldown.CooldownExecutor
import org.theclustermc.hub.utils.math.LocationIterator

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object TeleportationRift {
  private final val openRifts: Map[UUID, Tuple2[String, List[Location]]] = Map()

  private final val riftCloser: CooldownExecutor = new CooldownExecutor {
    override def use(player: Player, ability: String): Unit =
      if(has(player.getUniqueId)){
        TeleportationRift.get(player.getUniqueId)._2.foreach(_.getBlock.getState.update())
        remove(player.getUniqueId)
      }
  }

  def open(player: Player, server: String): Unit = {
    if(!has(player.getUniqueId) && !Hub.instance.cooldowns.isCooling(player.getUniqueId, "rift")){
      Hub.instance.cooldowns.add(player.getUniqueId, "rift", 7, riftCloser)
      val blocks: List[Location] = riftLocations(player.getLocation)
      blocks.foreach(player.sendBlockChange(_, Material.ENDER_PORTAL, 0.toByte))
      openRifts + (player.getUniqueId -> (server, blocks))
    }else{
      player.sendMessage(Hub.instance.msg.get("serverSelector.waitToUse"))
    }
  }

  def use(uuid: UUID): Unit = {
    Bukkit.getScheduler.runTaskLater(Hub.instance, new Nothing() {
      @Override def run() = {
        ServerTeleport.tpToServer(Bukkit.getPlayer(uuid), get(uuid)._1)
        remove(uuid)
      }
    }, 1L)
  }

  def get(uuid: UUID) = openRifts.get(uuid).get
  def has(uuid: UUID) = openRifts.contains(uuid)
  def remove(uuid: UUID)= if(has(uuid)) openRifts - uuid

  def riftLocations(loc: Location): List[Location] = {
    val iter = new LocationIterator(loc.getWorld, loc.toVector, loc.clone.getDirection.setY(0), 0, 4)
    val finalBlocks: List[Location] = List()
    while(iter.hasNext) finalBlocks.::(iter.next().subtract(0,1,0))
    finalBlocks
  }

}
