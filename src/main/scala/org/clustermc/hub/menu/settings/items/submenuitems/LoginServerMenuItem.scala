package org.clustermc.hub.menu.settings.items.submenuitems

import java.util.UUID

import io.mazenmc.menuapi.menu.Menu
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.menu.SubMenuInvItem
import org.clustermc.hub.menu.settings.LoginServerSettingsMenu
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object LoginServerMenuItem extends SubMenuInvItem {
    override val item: ItemStack = new ItemFactory(Material.COMPASS)
        .setDisplayName("Login Server")
        .setLore(0, "Choose the lobby you want to join when")
        .setLore(1, "You connect to the server")
        .getItemStack

    override def menu(player: Player): Menu = LoginServerSettingsMenu

    override def canOpen(uuid: UUID): Boolean = true
}
