package org.clustermc.hub.lottery.commands

import org.bukkit.entity.Player
import org.clustermc.hub.lottery.ClusterLottery
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

object ClusterLotteryCommand {

  def apply(player: Player): Unit ={
    player.sendMessage(Messages("lottery.cluster.header"))
    player.sendMessage(Messages("lottery.cluster.prize", MsgVar("{PRIZE}", ClusterLottery.lottery.getTotal)))
    player.sendMessage(Messages("lottery.cluster.enrolled",
      MsgVar("{ENROLLED}", ClusterLottery.lottery.values().contains(player.getUniqueId))))
    player.sendMessage("lottery.cluster.max")
    player.sendMessage("lottery.cluster.happensEvery")
    player.sendMessage("lottery.cluster.footer")
  }

  def apply(player: Player, string: String): Unit ={
    val amount = string.toInt
    if(!ClusterLottery.lottery.values().contains(player.getUniqueId)){
      if (amount != 0) {
        if (amount <= 200) {
          val cplayer = ClusterPlayer(player.getUniqueId)
          if (!cplayer.hasRank(PermissionRank.MOD)) {
            if (cplayer.bank.getClusterWallet.has(amount)) {
              cplayer.bank.getClusterWallet.withdraw(amount)
              ClusterLottery.lottery.add(amount, player.getUniqueId)
              player.sendMessage(Messages("lottery.success", MsgVar("{TYPE}", "Cluster"), MsgVar("{AMOUNT}", amount)))
            } else player.sendMessage(Messages("lottery.error.notEnough"))
          } else player.sendMessage(Messages("lottery.error.onlyNonStaff"))
        } else player.sendMessage(Messages("lottery.error.tooMany", MsgVar("{AMOUNT}", 200)))
      } else player.sendMessage(Messages("lottery.error.cantEnterZero"))
    }else player.sendMessage(Messages("lottery.error.alreadyEnrolled"))
  }

}
