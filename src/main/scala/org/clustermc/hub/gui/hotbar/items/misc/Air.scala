package org.clustermc.hub.gui.hotbar.items.misc

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.gui.hotbar.items.HotbarItem

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object Air extends HotbarItem{
  override val stack: ItemStack = new ItemStack(Material.AIR)

  override def click(player: Player, action: Action): Unit = {}
}
