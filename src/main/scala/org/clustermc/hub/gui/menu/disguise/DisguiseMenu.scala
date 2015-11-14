package org.clustermc.hub.gui.menu.disguise

import io.mazenmc.menuapi.menu.Menu
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.gui.menu.InvItem
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class DisguiseMenu extends Menu("Turn Into Your Favorite Creature", 27){

  setItem(0, new InvItem {
    override val item: ItemStack = new ItemFactory(Material.EGG).getItemStack
  })

}
