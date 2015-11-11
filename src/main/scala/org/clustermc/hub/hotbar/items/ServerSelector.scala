package org.clustermc.hub.hotbar.items

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.gui.serverselect.ServerSelectionMenu
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object ServerSelector extends HotbarItem{
  override val stack: ItemStack = new ItemFactory(Material.COMPASS).setDisplayName("Server Warper").getItemStack

  override def click(player: Player, action: Action): Unit = {
    if (action.name.contains("RIGHT")) {

    }

    else if (action.name.contains("LEFT"))
      ServerSelectionMenu.showTo(player)
  }
}
