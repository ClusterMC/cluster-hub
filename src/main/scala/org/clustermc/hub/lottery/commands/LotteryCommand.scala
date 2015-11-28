package org.clustermc.hub.lottery.commands

import org.clustermc.lib.command.CommandContext

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object LotteryCommand {

  //lottery (shard | cluster | s | c) <amount>
  //lottery shard | cluster
  def apply(context: CommandContext): Unit ={
    val channelBase = (context: CommandContext) => {
      val length = context.length
      if(length == 0) {
        LotteryHelp(context.sender)
        return
      }

      context.args(0).toLowerCase match {
        case "shard" | "s" | "shards" =>
          if(length == 1) ShardLotteryCommand(context.sender) else ShardLotteryCommand(context.sender, context.args(0))
        case "cluster" | "c" | "clusters" =>
          if(length == 1) ClusterLotteryCommand(context.sender) else ClusterLotteryCommand(context.sender, context.args(0))
        case "help" | "?" | "h" => LotteryHelp(context.sender)
        case anythin => LotteryHelp(context.sender)
      }
    }
  }

}
