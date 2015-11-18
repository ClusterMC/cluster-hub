package org.clustermc.hub.menu.serverselect.items

import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.clustermc.hub.Hub
import org.clustermc.hub.features.rift.TeleportationRift
import org.clustermc.hub.menu.InvItem
import org.clustermc.hub.player.HubPlayer
import org.clustermc.lib.bungee.ServerTeleport

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
        if(HubPlayer.get(player.getUniqueId).useRift.value.get)
            TeleportationRift.open(player, server)
        else
            ServerTeleport.tpToServer(Hub.instance, player, server)
    }

}
