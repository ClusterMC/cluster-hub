package org.theclustermc.hub.gui.serverselect

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import org.theclustermc.hub.gui.InvItem
import org.theclustermc.hub.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object ServerSelectItem extends InvItem{
  val item = new ItemFactory(Material.GRASS).setDisplayName("Island Battle").getItemStack

  override def use(player: Player, clickType: ClickType): Unit = ???
}
