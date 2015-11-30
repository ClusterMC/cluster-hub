package org.clustermc.hub.serverselect.rift

import java.util.UUID

import org.bukkit.Bukkit
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.{EventHandler, Listener}
import org.clustermc.hub.Hub
import org.clustermc.lib.utils.Done

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
@Done
class RiftEnterListener extends Listener {
    Bukkit.getServer.getPluginManager.registerEvents(this, Hub.instance)

    @EventHandler
    def onMove(event: PlayerMoveEvent): Unit = {
        val uuid: UUID = event.getPlayer.getUniqueId
        if(TeleportationRift.has(uuid)) {
            if(TeleportationRift.get(uuid)._2.contains(event.getPlayer.getLocation.getBlock.getLocation)) {
                TeleportationRift.use(uuid)
            }
        }
    }

}
