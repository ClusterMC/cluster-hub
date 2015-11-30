package org.clustermc.hub.main.hotbar.items

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.main.funstuff.menu.FunStuffMenu
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

object FunStuff extends HotbarItem {
    override val stack: ItemStack = new ItemFactory(Material.FIREWORK).setDisplayName("Fun Things").getItemStack

    override def click(player: Player, action: Action): Unit = FunStuffMenu.showTo(player)

}
