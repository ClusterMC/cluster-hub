package org.theclustermc.hub.inventory.items

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.theclustermc.hub.utils.{CaseInsensitiveOrdered, ItemFactory}

import scala.collection.immutable.TreeMap

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

abstract class InventoryItem {
  val stack: ItemStack
  def click(player: Player, action: Action)
}
object InventoryItem {
  val air = new ItemStack(Material.AIR)

  private final val items: Map[String, InventoryItem] = TreeMap(
    classOf[ReturnToMain].getSimpleName -> new ReturnToMain,
    classOf[ServerSelector].getSimpleName -> new ServerSelector
  )(CaseInsensitiveOrdered)

  def get(name: String) = {
    items.get(name).get
  }

}
