package org.clustermc.hub.player

import java.util.UUID

import com.mongodb.client.MongoCollection
import org.bson.Document
import org.clustermc.hub.PvPClass
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
    val boughtDisguises = new DisguiseStorage(playerId)

    //MISC
    var pvpClass: PvPClass = PvPClass.TANK

    override def save(database: MongoCollection[Document]): Unit = ???

    override def toDocument: Document = ???

    override def load(doc: Document): Unit = ???
}

object HubPlayer extends PlayerCoordinator[HubPlayer] {

    override protected def beforeUnload(uuid: UUID): Unit = ???

    override protected def afterLoad(player: HubPlayer): Unit = ???
}
