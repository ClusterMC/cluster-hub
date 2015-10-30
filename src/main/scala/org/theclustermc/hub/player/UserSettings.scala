package org.theclustermc.hub.player

import java.util.UUID

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class UserSettings {

  private var CHAT_MENTION: Boolean = true
  private var SHOW_PLAYERS: Boolean = true
  private var SERVER_ON_LOGIN: String = "HUB"
  private var USE_RIFT: Boolean = true
  private var ALLOW_MESSAGES: Boolean = true
  private var IGNORED: List[UUID] = null

}
