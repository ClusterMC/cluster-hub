package org.clustermc.hub.menu.settings

import io.mazenmc.menuapi.menu.Menu
import org.bukkit.entity.Player
import org.clustermc.hub.menu.settings.items.submenuitems.LoginServerMenuItem
import org.clustermc.hub.menu.settings.items.{ChatMention, ReceiveMessages, ShowPlayers, UseRift}
import org.clustermc.hub.player.HubPlayer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class SettingsMenu(player: Player) extends Menu("Cluster Settings", 36) {
    val ply = HubPlayer.get(player.getUniqueId)

    setItem(0, 1, new ChatMention(ply.chatMention.value.get))
    setItem(0, 7, new UseRift(ply.useRift.value.get))

    setItem(1, 4, LoginServerMenuItem)

    setItem(2, 2, new ReceiveMessages(ply.receiveMessages.value.get))
    setItem(2, 6, new ShowPlayers(ply.showPlayers.value.get))
}
