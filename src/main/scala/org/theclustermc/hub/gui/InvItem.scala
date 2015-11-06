package org.theclustermc.hub.gui

import io.mazenmc.menuapi.items.Item
import org.bukkit.inventory.ItemStack

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

trait InvItem extends Item{
  val item: ItemStack
  override def stack = item
}
