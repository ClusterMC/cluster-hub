package org.clustermc.hub.main.settings.items

import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import org.bukkit.{Bukkit, Material}
import org.clustermc.hub.main.settings.SettingsMenu
import org.clustermc.lib.ClusterLib
import org.clustermc.lib.gui.menu.{ConfirmMenu, InvItem}
import org.clustermc.lib.utils.{ItemFactory, TitleAPI}

import scala.collection.JavaConverters._

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 *
 * This file is part of Hub.
 *
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class SettingChangeConfirmMenu(item: SettingChangeConfirmItem)
  extends ConfirmMenu("Are you sure you want to change this?", item)

abstract class SettingChangeConfirmItem extends InvItem{

  override def act(player: Player, clickType: ClickType): Unit ={
    if(clickType.isLeftClick){
      TitleAPI.sendTitle(player, 5, 40, 5, "You changed your setting!", "")
      happen(player: Player)
    }
    player.closeInventory()
    Bukkit.getScheduler.scheduleSyncDelayedTask(ClusterLib.instance, new Runnable() {
      override def run(): Unit = if(player != null){
        new SettingsMenu(player).showTo(player)
      }
    }, 1)
  }

  def happen(player: Player): Unit

  override val item: ItemStack = new ItemFactory(Material.STAINED_GLASS_PANE)
    .setDurability(5)
    .setDisplayName("Are you sure you want to change this?")
    .setLore(List("&cRIGHT CLICK FOR NOPE", "&aLEFT CLICK FOR YEP").asJava)
    .getItemStack
}
