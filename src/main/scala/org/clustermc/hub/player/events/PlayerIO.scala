package org.clustermc.hub.player.events

import org.bukkit.event.player.{PlayerKickEvent, PlayerLoginEvent, PlayerQuitEvent}
import org.bukkit.event.{EventHandler, Listener}
import org.clustermc.hub.player.HubPlayer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
//lol
class PlayerIO extends Listener {

  @EventHandler def login(event: PlayerLoginEvent): Unit =
    HubPlayer.load(event.getPlayer.getUniqueId)

  @EventHandler def kicked(event: PlayerKickEvent): Unit =
    HubPlayer.unload(event.getPlayer.getUniqueId)

  @EventHandler def disconnected(event: PlayerQuitEvent): Unit =
    HubPlayer.unload(event.getPlayer.getUniqueId)
}
