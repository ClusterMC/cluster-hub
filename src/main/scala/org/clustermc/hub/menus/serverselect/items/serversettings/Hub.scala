package org.clustermc.hub.menus.serverselect.items.serversettings

import java.util

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.clustermc.hub.menus.InvItem
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

object Hub extends InvItem{
  val item = new ItemFactory(Material.MINECART).setDisplayName("Server Lobby").setLore(new util.ArrayList[String](
    util.Arrays.asList("Select The Lobby/Hub Server", "As your server to login to when", "You connect to our server")))
    .getItemStack

  override def act(player: Player, clickType: ClickType): Unit = {
    HubPlayer.get(player.getUniqueId).loginServer.value = "Hub"
  }
}
