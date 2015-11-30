package org.clustermc.hub.funstuff.menu.items

import java.util.UUID

import io.mazenmc.menuapi.menu.Menu
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.funstuff.disguise.menu.DisguiseMenu
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

object DisguiseSubItem extends SubMenuInvItem {
    override val item: ItemStack = new ItemFactory(Material.MONSTER_EGG)
        .setDisplayName("Disguises")
        .getItemStack

    override def menu(player: Player): Menu = new DisguiseMenu(player)

    override def canOpen(uuid: UUID): Boolean = true
}
