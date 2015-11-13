package org.clustermc.hub.gui.menu.settings.items

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

class ChatMention(value: Boolean) extends InvItem{
  override val item: ItemStack = new ItemFactory(Material.SIGN)
    .setDisplayName("Turn Chat Mentions " +  (if(value) "&a&lON" else "&c&lOFF"))
    .getItemStack

}
