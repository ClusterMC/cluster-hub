package org.clustermc.hub.menu.disguise

import me.libraryaddict.disguise.DisguiseAPI
import me.libraryaddict.disguise.disguisetypes.MobDisguise
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.DisguiseEnum
import org.clustermc.hub.menu.InvItem
import org.clustermc.hub.player.HubPlayer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class DisguiseItem(disguise: DisguiseEnum) extends InvItem{
  override val item: ItemStack = disguise.itemstack()

  override def act(player: Player, clickType: ClickType): Unit = {
    val hplayer = HubPlayer.get(player.getUniqueId)
    if(hplayer.boughtDisguises.has(disguise)){
      DisguiseAPI.disguiseToAll(player, new MobDisguise(disguise.getType/*, disguise.getAdult*/))//TODO
    }
  }
}