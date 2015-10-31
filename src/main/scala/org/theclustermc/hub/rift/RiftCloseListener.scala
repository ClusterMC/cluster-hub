package org.theclustermc.hub.rift

import org.bukkit.Bukkit
import org.bukkit.event.{EventHandler, Listener}
import org.theclustermc.hub.Hub
import org.theclustermc.hub.utils.cooldown.CooldownFinishEvent

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object RiftCloseListener extends Listener{

  Bukkit.getServer.getPluginManager.registerEvents(this, Hub.instance)

  @EventHandler
  def onRiftTimeout(event: CooldownFinishEvent): Unit = {
    if(event.getAbility == "RiftTimeout"){
      if(TeleportationRift.has(event.getPlayer)){
        TeleportationRift.get(event.getPlayer)._2.foreach(_.getBlock.getState.update())
      }
    }
  }

}
