package org.clustermc.hub.gui.menu.serverselect.items.servers

import org.bukkit.Material
import org.clustermc.hub.gui.menu.serverselect.items.ServerTransportItem
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object SkyWarsItem extends ServerTransportItem("skywars"){
  val item = new ItemFactory(Material.GRASS).setDisplayName("Island Battle").getItemStack
}
