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

object ArcherSelection extends ClassSelectionItem{
  override val helmet: ItemStack = new ItemStack(Material.LEATHER_HELMET)

  override val inventory: Array[ItemStack] = Array(new ItemFactory(Material.BOW)
    .addEnchantment(Enchantment.ARROW_DAMAGE, 3)
    .addEnchantment(Enchantment.ARROW_INFINITE, 1)
    .addEnchantment(Enchantment.ARROW_KNOCKBACK, 2).getItemStack, new ItemStack(Material.ARROW))

  override val stack: ItemStack = new ItemFactory(Material.BOW).setDisplayName("Archer").getItemStack
  override val pants: ItemStack = new ItemStack(Material.LEATHER_LEGGINGS)
  override val chest: ItemStack = new ItemStack(Material.LEATHER_CHESTPLATE)
  override val boots: ItemStack = new ItemStack(Material.LEATHER_BOOTS)
}
