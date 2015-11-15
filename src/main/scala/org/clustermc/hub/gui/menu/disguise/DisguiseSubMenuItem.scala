package org.clustermc.hub.gui.menu.disguise

import java.util.UUID

import org.bukkit.inventory.ItemStack
import org.clustermc.hub.DisguiseEnum
import org.clustermc.hub.gui.menu.SubMenuInvItem

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

abstract class DisguiseSubMenuItem(disguise: DisguiseEnum) extends SubMenuInvItem{
  override def canOpen(uuid: UUID): Boolean = true
  override val item: ItemStack = disguise.itemstack()
}
