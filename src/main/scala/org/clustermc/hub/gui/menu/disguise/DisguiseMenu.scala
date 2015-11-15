package org.clustermc.hub.gui.menu.disguise

import java.util.UUID

import io.mazenmc.menuapi.menu.Menu
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.gui.menu.SubMenuInvItem

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class DisguiseMenu(player: Player) extends Menu("Turn Into Your Favorite Creature", 27){

  //Horses
  setItem(0, new SubMenuInvItem {
    override def menu(player: Player): Menu =
    override def canOpen(uuid: UUID): Boolean = true
    override val item: ItemStack = _
  })

  //Zombies


}
