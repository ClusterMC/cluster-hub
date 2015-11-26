package org.clustermc.hub.player.events

import org.bukkit.Bukkit
import org.bukkit.event.player.{PlayerKickEvent, PlayerLoginEvent, PlayerQuitEvent}
import org.bukkit.event.{EventHandler, EventPriority, Listener}
import org.clustermc.hub.Hub
import org.clustermc.hub.player.HubPlayer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
class HubPlayerIO  extends Listener {

  Bukkit.getServer.getPluginManager.registerEvents(this, Hub.instance)

  @EventHandler(priority = EventPriority.HIGHEST)
  def login(event: PlayerLoginEvent): Unit = {
    if(!HubPlayer.loaded(event.getPlayer.getUniqueId) && !event.getResult.toString.contains("KICK")){
      HubPlayer(event.getPlayer.getUniqueId)
    }
  }

  @EventHandler(priority = EventPriority.LOWEST)
  def kicked(event: PlayerKickEvent): Unit = {
    HubPlayer.unload(event.getPlayer.getUniqueId)
  }

  @EventHandler(priority = EventPriority.LOWEST)
  def disconnected(event: PlayerQuitEvent): Unit = {
    HubPlayer.unload(event.getPlayer.getUniqueId)
  }

}
