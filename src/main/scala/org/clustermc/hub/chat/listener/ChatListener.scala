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
        val focused = playerData.focusedChannel

        focused match {
            case None | Some(pData) if !pData.canSend(player) =>
                playerData.setFocusedChannel(Channel.get("general"))
        }
        playerData.focusedChannel match {
            case None | Some(pD) if !pD.canSend(player) =>
                event.setFormat(s"${event.getFormat.replace("{channel)}", "") }")
                return
        }

        val _focused = focused.get
        if(event.getFormat.contains("{channel}")) {
            val format = s"${StringUtil.colorString(_focused.color)}${_focused.prefixOrName}${ChatColor.RESET}"
            event.setFormat(event.getFormat.replace("{channel}", format))
        } else {
            event.setFormat(s"${ChatColor.GOLD }${_focused.name }${ChatColor.RESET }${event.getFormat }")
        }

        //strip players
        val iter = event.getRecipients.iterator()
        while(iter.hasNext) {
            val p = iter.next()
            val data = HubPlayer.get(p.getUniqueId).channelStorage
            if(!data.isSubscribed(_focused)) {
                iter.remove()
            }
        }
    }
}
