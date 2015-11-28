package org.clustermc.hub.pvp

import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.{EventHandler, EventPriority, Listener}
import org.clustermc.hub.main.hotbar.MainHubHotbar
import org.clustermc.lib.player.ClusterPlayer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class PlayerDeath extends Listener{

  @EventHandler(priority = EventPriority.LOWEST)
  def onDamage(event: EntityDamageEvent): Unit ={
    if(event.getEntity.isInstanceOf[Player]){
      val player = event.getEntity.asInstanceOf[Player]
      if(player.getHealth - event.getFinalDamage <= 0){
        event.setCancelled(true)
        val cplayer = ClusterPlayer(player.getUniqueId)
        cplayer.canInteract = false
        cplayer.playerDamageable = false
        player.setHealth(player.getMaxHealth)
        MainHubHotbar.send(player)
        player.teleport(player.getLocation)//TODO get the correct location
      }
    }
  }

}
