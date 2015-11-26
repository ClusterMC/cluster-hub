package org.clustermc.hub.menu.settings

import io.mazenmc.menuapi.menu.Menu
import org.bukkit.entity.Player
import org.clustermc.hub.menu.settings.items.submenuitems.LoginServerMenuItem
import org.clustermc.hub.menu.settings.items.{ChatMention, ReceiveMessages, ShowPlayers, UseRift}
import org.clustermc.hub.player.HubPlayer
import org.clustermc.lib.player.ClusterPlayer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class SettingsMenu(player: Player) extends Menu("Cluster Settings", 36) {
    val hplayer = HubPlayer(player.getUniqueId)
    val cplayer = ClusterPlayer(player.getUniqueId)

    setItem(0, 1, new ChatMention(cplayer.chatMention))
    setItem(0, 7, new UseRift(hplayer.useRift))

    setItem(1, 4, LoginServerMenuItem)

    setItem(2, 2, new ReceiveMessages(cplayer.receiveMessages))
    setItem(2, 6, new ShowPlayers(cplayer.showPlayers))
}
