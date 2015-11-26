package org.clustermc.hub.menu.settings.items.serversettings

import java.util

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
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

object SkyWarsItem extends InvItem {
    val item = new ItemFactory(Material.GRASS).setDisplayName("Island Battle").setLore(new util.ArrayList[String](
        util.Arrays.asList("Select Island Battle Server", "As your server to login to when", "You connect to our server")))
        .getItemStack

    override def act(player: Player, clickType: ClickType): Unit = {
        HubPlayer(player.getUniqueId).loginServer = "SkyWars"
    }
}
