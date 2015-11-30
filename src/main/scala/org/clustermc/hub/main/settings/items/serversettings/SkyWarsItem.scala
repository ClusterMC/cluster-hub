package org.clustermc.hub.main.settings.items.serversettings

import java.util
import java.util.UUID

import io.mazenmc.menuapi.menu.Menu
import org.bukkit.Material
import org.bukkit.entity.Player
import org.clustermc.hub.main.settings.items.{SettingChangeConfirmItem, SettingChangeConfirmMenu}
import org.clustermc.hub.player.HubPlayer
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

object SkyWarsItem extends SubMenuInvItem {
    val item = new ItemFactory(Material.GRASS).setDisplayName("Island Battle").setLore(new util.ArrayList[String](
        util.Arrays.asList("Select Island Battle Server", "As your server to login to when", "You connect to our server")))
        .getItemStack

    override def menu(player: Player): Menu = new SettingChangeConfirmMenu(new SettingChangeConfirmItem {
        override def happen(player: Player): Unit = HubPlayer(player.getUniqueId).loginServer = "SkyWars"
    })

    override def canOpen(uuid: UUID): Boolean = true
}
