package org.clustermc.hub.pvp.hotbar.items

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.clustermc.lib.utils.ItemFactory

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object TankSelection extends ClassSelectionItem{
  override val helmet: ItemStack = new ItemStack(Material.IRON_HELMET)

  override val inventory: Array[ItemStack] = Array(new ItemFactory(Material.DIAMOND_SWORD)
    .addEnchantment(Enchantment.KNOCKBACK, 1).getItemStack)

  override val stack: ItemStack = new ItemFactory(Material.DIAMOND_CHESTPLATE).setDisplayName("Tanker").getItemStack
  override val pants: ItemStack = new ItemStack(Material.IRON_LEGGINGS)
  override val chest: ItemStack = new ItemStack(Material.IRON_CHESTPLATE)
  override val boots: ItemStack = new ItemStack(Material.IRON_BOOTS)
}
