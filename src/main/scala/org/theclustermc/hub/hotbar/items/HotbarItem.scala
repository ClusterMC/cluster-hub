package org.theclustermc.hub.hotbar.items

import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.theclustermc.lib.utils.CaseInsensitiveOrdered

import scala.collection.immutable.TreeMap

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
object HotbarItem {

  private final val items: Map[String, HotbarItem] = TreeMap(
    ReturnToMain.getClass.getSimpleName -> ReturnToMain,
    ServerSelector.getClass.getSimpleName -> ServerSelector
  )(CaseInsensitiveOrdered)

  def get(name: String): HotbarItem = {
    items.get(name).get
  }

}
