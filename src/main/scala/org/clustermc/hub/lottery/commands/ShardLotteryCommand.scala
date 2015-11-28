package org.clustermc.hub.lottery.commands

import org.bukkit.entity.Player
import org.clustermc.hub.lottery.ShardLottery
import org.clustermc.lib.enums.PermissionRank
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

object ShardLotteryCommand {

  def apply(player: Player): Unit ={
    player.sendMessage(Messages("lottery.shard.header"))
    player.sendMessage(Messages("lottery.shard.prize", MsgVar("{PRIZE}", ShardLottery.lottery.getTotal)))
    player.sendMessage(Messages("lottery.shard.enrolled",
      MsgVar("{ENROLLED}", ShardLottery.lottery.values().contains(player.getUniqueId))))
    player.sendMessage("lottery.shard.max")
    player.sendMessage("lottery.shard.happensEvery")
    player.sendMessage("lottery.shard.footer")
  }

  def apply(player: Player, string: String): Unit ={
    val amount = string.toInt
    if(!ShardLottery.lottery.values().contains(player.getUniqueId)){
      if (amount != 0) {
        if (amount <= 1000) {
          val cplayer = ClusterPlayer(player.getUniqueId)
          if (!cplayer.hasRank(PermissionRank.MOD)) {
            if (cplayer.bank.getShardWallet.has(amount)) {
              cplayer.bank.getShardWallet.withdraw(amount)
              ShardLottery.lottery.add(amount, player.getUniqueId)
              player.sendMessage(Messages("lottery.success", MsgVar("{TYPE}", "Shard"), MsgVar("{AMOUNT}", amount)))
            } else player.sendMessage(Messages("lottery.error.notEnough"))
          } else player.sendMessage(Messages("lottery.error.onlyNonStaff"))
        } else player.sendMessage(Messages("lottery.error.tooMany", MsgVar("{AMOUNT}", 1000)))
      } else player.sendMessage(Messages("lottery.error.cantEnterZero"))
    }else player.sendMessage(Messages("lottery.error.alreadyEnrolled"))
  }

}
