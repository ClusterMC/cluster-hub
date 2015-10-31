package org.theclustermc.hub.guitest

import io.mazenmc.menuapi.items.Item
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

abstract class InvItem extends Item{
  val item: ItemStack
  override def stack = item

  override def act(player: Player, clickType: ClickType): Unit = use(player, clickType)

  abstract def use(player: Player, clickType: ClickType): Unit

}
