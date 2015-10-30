package org.theclustermc.hub.inventory.pages

import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.theclustermc.hub.inventory.items.{InventoryItem, ReturnToMain, ServerSelector}
import org.theclustermc.hub.utils.CaseInsensitiveOrdered

import scala.collection.immutable.TreeMap

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

abstract class InventorySet (val items: Array[InventoryItem]) {

  lazy val name: String = this.getClass.getSimpleName

  if(items.length != 9){
    throw ArrayIndexOutOfBoundsException
  }

  def use(player: Player, slot: Int, action: Action): Unit = {
    if(slot <= 8 && slot >= 0)
      items(slot).click(player, action)
  }

  def send(player: Player): Unit = {
    for(i <- 0 to 8) player.getInventory.setItem(i, items(i).stack)
    player.updateInventory()
  }

}

object InventorySet {

  private final val hotbars: Map[String, InventorySet] = TreeMap(
    classOf[MainHubInventory].getSimpleName -> new MainHubInventory
  )(CaseInsensitiveOrdered)

  def get(name: String): InventorySet = hotbars.get(name).get

}
