package org.clustermc.hub.disguise.menu

import me.libraryaddict.disguise.DisguiseAPI
import me.libraryaddict.disguise.disguisetypes.MobDisguise
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import org.clustermc.hub.DisguiseEnum
import org.clustermc.hub.player.HubPlayer
import org.clustermc.lib.gui.menu.InvItem
import org.clustermc.lib.utils.TitleAPI

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class DisguiseItem(disguise: DisguiseEnum) extends InvItem {
    override val item: ItemStack = disguise.itemstack()

    override def act(player: Player, clickType: ClickType): Unit = {
        val hplayer = HubPlayer(player.getUniqueId)
        if(hplayer.disguises.has(disguise)) {
            player.closeInventory()
            TitleAPI.sendTitle(player, 5, 40, 5, "Youre disguised as " + disguise.getName, "HAVE FUN!")
            DisguiseAPI.disguiseToAll(player, new MobDisguise(disguise.getType /*, disguise.getAdult*/)) //TODO
        }else{

        }
    }
}
