package org.clustermc.hub.main.hotbar.items

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.clustermc.lib.gui.hotbar.HotbarItem
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object PvpToggle extends HotbarItem {
    override val stack: ItemStack = new ItemFactory(Material.DIAMOND_SWORD)
        .setDisplayName("PvP Toggle / R-Click for class selection").getItemStack

    override def click(player: Player, action: Action): Unit = {

    }
}
