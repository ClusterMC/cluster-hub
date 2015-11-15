package org.clustermc.hub

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask
import org.clustermc.hub.features.lottery.{ClusterLottery, ShardLottery}
import org.clustermc.hub.player.HubPlayer
import org.clustermc.lib.utils.cooldown.CooldownHandler
import org.clustermc.lib.utils.database.MongoDB
import org.clustermc.lib.utils.{CustomConfig, Messages}

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class Hub extends JavaPlugin{

  private var _mongoDB: MongoDB = null
  private var _messages: Messages = null
  private var _cooldowns: CooldownHandler = null

  private var cooldownTask: BukkitTask = null

  def database = _mongoDB
  def msg = _messages
  def cooldowns = _cooldowns

  override def onEnable(): Unit ={
    Hub._instance = this
    _messages = new Messages(new CustomConfig(this.getDataFolder, "lang"))
    _mongoDB = new MongoDB(new CustomConfig(this.getDataFolder, "db").getConfig)
    _cooldowns = new CooldownHandler

    ClusterLottery.startNew()
    ShardLottery.startNew()

    cooldownTask = getServer.getScheduler.runTaskTimerAsynchronously(this, new Runnable {
      override def run(): Unit = _cooldowns.handleCooldowns()
    }, 20L, 5L)
  }

  override def onDisable(): Unit ={
    HubPlayer.unloadAll()
    Hub._instance = null
    _mongoDB.getClient.close()
    cooldownTask.cancel()
  }
}

object Hub{
  private var _instance: Hub = null
  def instance: Hub = _instance
}
