package org.clustermc.hub.hotbar

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.hotbar.hub.MainHubHotbar
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

abstract class HotbarItem {
  val stack: ItemStack
  def click(player: Player, action: Action)
}

object Air extends HotbarItem{
  override val stack: ItemStack = new ItemStack(Material.AIR)
  override def click(player: Player, action: Action): Unit = {}
}

object ReturnToMain extends HotbarItem{

  override val stack: ItemStack = new ItemFactory(Material.COMPASS)
    .setDisplayName("Return To Main Hotbar Menu")
    .getItemStack

  override def click(player: Player, action: Action): Unit = {
    if (action.name.contains("RIGHT"))
      Hotbar.get(MainHubHotbar.getClass.getSimpleName).send(player)
  }
}

/*object HotbarItem {

  private final val items: Map[String, HotbarItem] = TreeMap(
    ReturnToMain.getClass.getSimpleName -> ReturnToMain,
    ServerSelector.getClass.getSimpleName -> ServerSelector
  )(CaseInsensitiveOrdered)

  def get(name: String): HotbarItem = {
    items.get(name).get
  }

}*/

