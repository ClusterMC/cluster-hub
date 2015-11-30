package org.clustermc.hub.main.settings.items.settings

import java.util.UUID

import io.mazenmc.menuapi.menu.Menu
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.main.settings.items.{SettingChangeConfirmItem, SettingChangeConfirmMenu}
import org.clustermc.lib.gui.menu.SubMenuInvItem
import org.clustermc.lib.player.ClusterPlayer
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class ShowPlayers(value: Boolean) extends SubMenuInvItem {
    override val item: ItemStack = new ItemFactory(Material.THIN_GLASS)
        .setDisplayName("Turn Player Visibility " + (if(!value) "&a&lON" else "&c&lOFF"))
        .getItemStack

    override def menu(player: Player): Menu = new SettingChangeConfirmMenu(new SettingChangeConfirmItem {
        override def happen(player: Player): Unit = ClusterPlayer(player.getUniqueId).showPlayers = !value
    })

    override def canOpen(uuid: UUID): Boolean = true

}
