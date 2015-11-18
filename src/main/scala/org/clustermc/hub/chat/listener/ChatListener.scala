package org.clustermc.hub.chat.listener

import org.bukkit.ChatColor
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.{EventHandler, EventPriority, Listener}
import org.clustermc.hub.chat.channel.Channel
import org.clustermc.hub.player.HubPlayer
import org.clustermc.lib.utils.StringUtil

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
//TODO Cleanup
class ChatListener extends Listener {

  @throws[RuntimeException]
  @EventHandler(priority = EventPriority.HIGHEST)
  def asyncChat(event: AsyncPlayerChatEvent): Unit = {
    val player = event.getPlayer
    val playerData = HubPlayer.get(player.getUniqueId).channelStorage
    var focused = playerData.focusedChannel
    if(focused.isEmpty || !focused.get.canSend(player)) {
      focused = Channel.get("general")
      playerData.setFocusedChannel(focused)
      if(focused.isEmpty || !focused.get.canSend(player)) {
        event.setFormat(s"${event.getFormat.replace("{channel)}", "")}")
        return
      }
    }
    if(event.getFormat.contains("{channel}")) {
      event.setFormat(event.getFormat.replace("{channel}",
        s"${StringUtil.colorString(focused.get.color)}${
          if(focused.get.prefix.equals(""))
            focused.get.name
          else
            focused.get.prefix
        }${ChatColor.RESET}"))
    } else {
      event.setFormat(s"${ChatColor.GOLD}${focused.get.name}${ChatColor.RESET}${event.getFormat}")
    }

    //strip players
    val r = event.getRecipients
    val iter = r.iterator()
    while(iter.hasNext) {
      val p = iter.next()
      val data = HubPlayer.get(p.getUniqueId).channelStorage
      if(!data.isSubscribed(focused.get)) {
        iter.remove()
      }
    }
  }
}
