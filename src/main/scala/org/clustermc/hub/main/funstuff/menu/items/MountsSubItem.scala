package org.clustermc.hub.main.funstuff.menu.items

import java.util.UUID

import io.mazenmc.menuapi.menu.Menu
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.disguise.menu.DisguiseMenu
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

object MountsSubItem extends SubMenuInvItem {
    override val item: ItemStack = new ItemFactory(Material.SADDLE)
        .setDisplayName("Mounts -- Coming Soon")
        .getItemStack

    override def menu(player: Player): Menu = new DisguiseMenu(player)

    override def canOpen(uuid: UUID): Boolean = false
}
