package org.clustermc.hub.menu.settings.items

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.menu.InvItem
import org.clustermc.hub.player.HubPlayer
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class ShowPlayers(value: Boolean) extends InvItem {
    override val item: ItemStack = new ItemFactory(Material.THIN_GLASS)
        .setDisplayName("Turn Player Visibility " + (if(!value) "&a&lON" else "&c&lOFF"))
        .getItemStack

    override def act(player: Player, clickType: ClickType): Unit = {
        HubPlayer.get(player.getUniqueId).showPlayers.value = !value
    }

}
