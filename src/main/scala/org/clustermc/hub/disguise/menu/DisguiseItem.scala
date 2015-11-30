package org.clustermc.hub.disguise.menu

import java.util.UUID

import io.mazenmc.menuapi.menu.Menu
import me.libraryaddict.disguise.DisguiseAPI
import me.libraryaddict.disguise.disguisetypes.MobDisguise
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.DisguiseEnum
import org.clustermc.hub.player.HubPlayer
import org.clustermc.lib.gui.menu.SubMenuInvItem
import org.clustermc.lib.player.ClusterPlayer
import org.clustermc.lib.utils.TitleAPI

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class DisguiseItem(disguise: DisguiseEnum) extends SubMenuInvItem {
  override val item: ItemStack = disguise.itemstack()

  override def menu(player: Player): Menu = new DisguiseConfirmMenu(new DisguiseConfirmItem {
    override def happen(player: Player): Unit = {
      HubPlayer(player.getUniqueId).disguises.buy(disguise)
      TitleAPI.sendTitle(player, 5, 40, 5, "You unlocked the " + disguise.getName + " disguise!", "And you have been disguised as it!")
    }
  })

  override def canOpen(uuid: UUID): Boolean = {
    val hplayer = HubPlayer(uuid)
    val player = hplayer.bukkitPlayer
    if (hplayer.disguises.has(disguise)) {
      player.closeInventory()
      TitleAPI.sendTitle(player, 5, 40, 5, "Youre disguised as " + disguise.getName, "HAVE FUN!")
      DisguiseAPI.disguiseToAll(player, new MobDisguise(disguise.getType /*, disguise.getAdult*/))
      false
    }else{
      if (ClusterPlayer(player.getUniqueId).bank.getClusterWallet.has(disguise.getCost)) true
      else false
    }
  }

}
