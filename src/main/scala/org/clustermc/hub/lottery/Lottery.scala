package org.clustermc.hub.lottery

import java.util.UUID

import org.bukkit.Bukkit
import org.clustermc.hub.Hub
import org.clustermc.lib.utils.WeightedRandomCollection

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

trait Lottery {

    val minutes: Int
    var lastWinner: UUID = null
    var lottery: WeightedRandomCollection[UUID] = null

    def startNew(): Unit = {
        lottery = new WeightedRandomCollection[UUID]
        Bukkit.getScheduler.runTaskLaterAsynchronously(Hub.instance, new Runnable {
            override def run(): Unit = end()
        }, 20 /*tick*/ * 60 /*seconds*/ * minutes /*minutes*/)
    }

    def pickWinner(): Unit = {
        lastWinner = lottery.next()
    }

    def giveRewardTo(winner: UUID)

    def end(): Unit = {
        pickWinner()
        giveRewardTo(lastWinner)
        startNew()
    }

}
