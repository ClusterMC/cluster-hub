package org.theclustermc.hub

import org.bukkit.plugin.java.JavaPlugin
import org.theclustermc.hub.utils.{Messages, CustomConfig}
import org.theclustermc.hub.utils.database.MongoDB

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

  def database = _mongoDB

  override def onEnable(): Unit ={
    Hub._instance = this
    _messages = new Messages(new CustomConfig(this.getDataFolder, "lang"))
    _mongoDB = new MongoDB(new CustomConfig(this.getDataFolder, "db").getConfig)
  }

  override def onDisable(): Unit ={
    Hub._instance = null
  }

}

object Hub{
  private var _instance: Hub = null
  def instance: Hub = _instance
}