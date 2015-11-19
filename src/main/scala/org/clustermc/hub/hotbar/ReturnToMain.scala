package org.clustermc.hub.hotbar

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.block.Action
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.hotbar.hub.MainHubHotbar
import org.clustermc.lib.gui.hotbar.{Hotbar, HotbarItem}
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Default (Template) Project.
 * 
 * Default (Template) Project can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object ReturnToMain extends HotbarItem {

     override val stack: ItemStack = new ItemFactory(Material.COMPASS)
         .setDisplayName("Return To Main Hotbar Menu")
         .getItemStack

     override def click(player: Player, action: Action): Unit = {
         if(action.name.contains("RIGHT"))
             Hotbar.get(MainHubHotbar.getClass.getSimpleName).send(player)
     }
 }
