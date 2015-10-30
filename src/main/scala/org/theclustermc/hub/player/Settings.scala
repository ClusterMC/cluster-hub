package org.theclustermc.hub.player

import org.theclustermc.hub.player.Setting.Settingg

import scala.collection.mutable

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class Settings {
  private var settings: mutable.HashMap[Setting, SettingValue] = null

  def this() {
    this()
    settings = new mutable.HashMap[Settingg , SettingValue]
    settings.+=(Setting.PVP, null)
  }

}
