package org.clustermc.hub.menu.settings.items.submenuitems

import java.util.UUID

import io.mazenmc.menuapi.menu.Menu
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.menu.settings.SettingsMenu
import org.clustermc.lib.gui.menu.SubMenuInvItem
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object SettingsMenuItem extends SubMenuInvItem {
    override val item: ItemStack = new ItemFactory(Material.BARRIER)
        .setDisplayName("Return To Settings Menu")
        .getItemStack

    override def menu(player: Player): Menu = new SettingsMenu(player)

    override def canOpen(uuid: UUID): Boolean = true
}
