package org.clustermc.hub

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.clustermc.hub.features.lottery.{ClusterLottery, ShardLottery}
import org.clustermc.hub.player.HubPlayer
import org.clustermc.lib.ClusterLib

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class Hub extends JavaPlugin {
    override def onEnable(): Unit = {
        Hub._instance = this
        Bukkit.getServer.getPluginManager.getPlugin("ClusterLib")
        .asInstanceOf[ClusterLib].assign[HubPlayer]()
        ClusterLottery.startNew()
        ShardLottery.startNew()
    }

    override def onDisable(): Unit = {
        HubPlayer.unloadAll()
        Hub._instance = null
    }
}

object Hub {
    private var _instance: Hub = null
    def instance: Hub = _instance
}
