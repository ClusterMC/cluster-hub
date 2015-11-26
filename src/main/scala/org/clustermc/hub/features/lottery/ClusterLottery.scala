package org.clustermc.hub.features.lottery

import java.util.UUID

import org.bukkit.Bukkit
import org.clustermc.lib.player.ClusterPlayer
import org.clustermc.lib.utils.messages.{Messages, MsgVar}

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object ClusterLottery extends Lottery {
    override val minutes: Int = 60 * 24

    override def giveRewardTo(winner: UUID): Unit = {
        val player = ClusterPlayer(winner)
        player.bank.getClusterWallet.deposit(lottery.getTotal)
        Bukkit.getServer.broadcastMessage(Messages("lottery.cluster.winningAnnouncement",
            MsgVar("{AMOUNT}", lottery.getTotal),
            MsgVar("{PLAYER}", player.latestName)))
    }
}
