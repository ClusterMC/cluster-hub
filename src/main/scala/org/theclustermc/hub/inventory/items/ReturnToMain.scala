package org.theclustermc.hub.inventory.items

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.theclustermc.hub.inventory.pages.{InventorySet, MainHubInventory}
import org.theclustermc.hub.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class ReturnToMain extends InventoryItem{

  override val stack: ItemStack = new ItemFactory(Material.COMPASS)
    .setDisplayName("Return To Main Hotbar Menu")
    .getItemStack

  override def click(player: Player, action: Action): Unit = {
    if (action.name.contains("RIGHT"))
      InventorySet.get(classOf[MainHubInventory].getSimpleName).send(player)
  }
}
