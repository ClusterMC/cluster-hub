package org.clustermc.hub.gui.serverselect.items

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.clustermc.hub.Hub
import org.clustermc.hub.gui.InvItem
import org.theclustermc.lib.bungee.ServerTeleport
import org.theclustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object CreativeItem extends InvItem{
  val item = new ItemFactory(Material.DRAGON_EGG).setDisplayName("Mystic Absents Creative").getItemStack

  override def act(player: Player, clickType: ClickType): Unit = {
    ServerTeleport.tpToServer(Hub.instance, player, "Creative")
  }
}
