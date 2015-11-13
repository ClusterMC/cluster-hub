package org.clustermc.hub.gui.menu.disguise

import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.gui.menu.InvItem

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class DisguiseItem() extends InvItem{
  override val item: ItemStack = null

  override def act(player: Player, clickType: ClickType): Unit = super.act(player, clickType)
}
