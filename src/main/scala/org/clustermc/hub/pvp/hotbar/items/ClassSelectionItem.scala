package org.clustermc.hub.pvp.hotbar.items

import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.clustermc.lib.gui.hotbar.HotbarItem
import org.clustermc.lib.player.ClusterPlayer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

abstract class ClassSelectionItem extends HotbarItem{
  val helmet, chest, pants, boots: ItemStack
  val inventory: Array[ItemStack]

   override def click(player: Player, action: Action): Unit = {
     val cplayer = ClusterPlayer(player.getUniqueId)
     cplayer.canInteract = true
     cplayer.playerDamageable = true

     player.getInventory.clear()
     player.getInventory.setContents(inventory)
     player.getInventory.setBoots(boots)
     player.getInventory.setChestplate(chest)
     player.getInventory.setHelmet(helmet)
     player.getInventory.setLeggings(pants)
     player.updateInventory()
   }

 }
