package org.clustermc.hub.hotbar.items.main

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.hotbar.items.HotbarItem
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object Disguises extends HotbarItem {
  override val stack: ItemStack = new ItemFactory(Material.DRAGON_EGG)
    .setDisplayName("Disguises").getItemStack

  override def click(player: Player, action: Action): Unit = {

  }
}