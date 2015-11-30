package org.clustermc.hub.player

import java.util.UUID

import com.mongodb.client.MongoCollection
import com.mongodb.client.model.UpdateOptions
import org.bson.Document
import org.clustermc.hub.player.storages.DisguiseStorage
import org.clustermc.lib.player.{PlayerCoordinator, PlayerWrapper}

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class HubPlayer(playerId: UUID) extends PlayerWrapper(playerId) {
  //SETTINGS
  var loginServer: String = "Hub"
  var useRift = true

  //PURCHASES
  val disguises = new DisguiseStorage(playerId)

  override def save(database: MongoCollection[Document]): Unit = {
    database.updateOne(new Document(HubPlayer.index, playerId), toDocument,
      new UpdateOptions().upsert(true))
  }

  override def toDocument: Document = {
    new Document()
      .append("settings", new Document()
        .append("loginServer", loginServer)
        .append("useRift", useRift))
      .append("disguises", disguises.serialize())
  }

  override def load(doc: Document): Unit = {
    loginServer = doc.getString("settings.loginServer")
    useRift = doc.getBoolean("useRift")
    disguises.deserialize(doc.getString("disguises"))
  }
}

object HubPlayer extends PlayerCoordinator[HubPlayer] {

  override protected def beforeUnload(uuid: UUID): Unit = {
    //Nothing yet
  }

  override protected def afterLoad(player: HubPlayer): Unit = {
    //Nothing yet
  }
}
