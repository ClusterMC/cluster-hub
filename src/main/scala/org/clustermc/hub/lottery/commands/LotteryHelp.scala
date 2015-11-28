package org.clustermc.hub.lottery.commands

import org.bukkit.entity.Player
import org.clustermc.lib.utils.StringUtil

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object LotteryHelp {

  val help = StringUtil.colorArray(Array(
    "&f=====&b&lHow It Works&f=====",
    "  &7The lotteries happen at set intervals of time. The &b'Cluster Lottery' &7gives rewards as",
    "  &bClusters&7, whereas the &b'Shard Lottery'&7 gives rewards as &bShards",
    "&f=====&b&lUsing The Lottery&f=====",
    "  &f/lottery &f(&bcluster&f|&bshard&f) &7-- gives details about specified lottery",
    "  &f/lottery &bshard &f(&bamount&f) &7-- enters Shard Lottery with &bamount &7shards",
    "  &f/lottery &bcluster &f(&bamount&f) &7-- enters Cluster Lottery with &bamount &7clusters"))

  def apply(sender: Player) = sender.sendMessage(help)

}
