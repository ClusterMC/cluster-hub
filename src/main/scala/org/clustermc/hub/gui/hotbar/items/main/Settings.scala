package org.clustermc.hub.gui.hotbar.items.main

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.gui.hotbar.items.HotbarItem
import org.clustermc.hub.gui.menu.settings.SettingsMenu
import org.clustermc.lib.utils.{Done, ItemFactory}

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
@Done
object Settings extends HotbarItem {
  override val stack: ItemStack = new ItemFactory(Material.COMMAND)
    .setDisplayName("Server Settings").getItemStack

  override def click(player: Player, action: Action): Unit = new SettingsMenu(player).showTo(player)
}
