package org.clustermc.hub.serverselect.menu.items

import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.clustermc.hub.Hub
import org.clustermc.hub.player.HubPlayer
import org.clustermc.hub.serverselect.rift.TeleportationRift
import org.clustermc.lib.bungee.ServerTeleport
import org.clustermc.lib.gui.menu.InvItem

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

abstract class ServerTransportItem(server: String) extends InvItem {

    override def act(player: Player, clickType: ClickType): Unit = {
        if(HubPlayer(player.getUniqueId).useRift)
            TeleportationRift.open(player, server)
        else
            ServerTeleport.tpToServer(Hub.instance, player, server)
    }

}
