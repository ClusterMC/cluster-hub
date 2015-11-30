package org.clustermc.hub.main.settingsmenu.items

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.player.HubPlayer
import org.clustermc.lib.gui.menu.InvItem
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class UseRift(value: Boolean) extends InvItem {
    override val item: ItemStack = new ItemFactory(Material.SIGN)
        .setDisplayName("Turn Selector Rift " + (if(!value) "&a&lON" else "&c&lOFF"))
        .setLore(0, "Toggle the rift that appears in the floor when you use your compass")
        .getItemStack

    override def act(player: Player, clickType: ClickType): Unit = {
        HubPlayer(player.getUniqueId).useRift = !value
    }

}
