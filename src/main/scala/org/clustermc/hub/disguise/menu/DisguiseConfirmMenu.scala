package org.clustermc.hub.disguise.menu

import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import org.bukkit.{Bukkit, Material}
import org.clustermc.lib.ClusterLib
import org.clustermc.lib.gui.menu.{ConfirmMenu, InvItem}
import org.clustermc.lib.utils.ItemFactory

import scala.collection.JavaConverters._

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class DisguiseConfirmMenu(item: DisguiseConfirmItem) extends ConfirmMenu("Are you sure you want to buy this?", item)

abstract class DisguiseConfirmItem extends InvItem{

  override def act(player: Player, clickType: ClickType): Unit ={
    if(clickType.isLeftClick){
      player.closeInventory()
      happen(player)
    }else if(clickType.isRightClick){
      player.closeInventory()
      Bukkit.getScheduler.scheduleSyncDelayedTask(ClusterLib.instance, new Runnable() {
        override def run(): Unit = if(player != null){
          new DisguiseMenu(player).showTo(player)
        }
      }, 1)
    }
  }

  def happen(player: Player): Unit

  override val item: ItemStack = new ItemFactory(Material.STAINED_GLASS_PANE)
    .setDurability(5)
    .setDisplayName("Are you sure you want to buy this disguise?")
    .setLore(List("&cRIGHT CLICK FOR NOPE", "&aLEFT CLICK FOR YEP").asJava)
    .getItemStack
}
