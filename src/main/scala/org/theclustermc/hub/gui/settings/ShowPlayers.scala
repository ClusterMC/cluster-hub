package org.theclustermc.hub.gui.settings

import org.bukkit.Material
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

class ShowPlayers(value: Boolean) extends InvItem{
  override val item: ItemStack = new ItemFactory(Material.THIN_GLASS)
    .setDisplayName("Turn Player Visibility " +  (if(value) "&a&lON" else "&c&lOFF"))
    .getItemStack


}
