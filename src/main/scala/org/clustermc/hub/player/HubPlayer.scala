package org.clustermc.hub.player

import java.util.UUID

import org.bson.Document
import org.clustermc.lib.data.mutable.SettingData
import org.clustermc.lib.utils.Coordinator
import org.clustermc.lib.utils.database.PlayerWrapper

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class HubPlayer(playerId: UUID) extends PlayerWrapper(playerId){

  val loginServer: SettingData[String] = SettingData("Hub", "Hub", classOf[String])

  override def toDocument: Document = ???

  override def load(doc: Document): Unit = ???
}

object HubPlayer extends Coordinator[UUID, HubPlayer, UUID]{

  override def unload(key: UUID): Unit = ???

  override def unloadAll(): Unit = ???

  override def load(load: UUID): Unit = ???
}
