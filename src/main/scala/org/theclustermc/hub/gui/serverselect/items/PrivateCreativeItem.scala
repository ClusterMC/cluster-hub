package org.theclustermc.hub.gui.serverselect.items

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.theclustermc.hub.bungee.ServerTeleport
import org.theclustermc.hub.gui.InvItem
import org.theclustermc.hub.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object PrivateCreativeItem extends InvItem{
  val item = new ItemFactory(Material.GRASS).setDisplayName("Mystic Absents Private").getItemStack

  override def act(player: Player, clickType: ClickType): Unit = {
    ServerTeleport.tpToServer(player, "MysticAbsents")
  }
}
