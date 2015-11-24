package org.clustermc.hub.player

import java.util.UUID

import org.bson.Document
import org.clustermc.hub.PvPClass
import org.clustermc.hub.player.storages.DisguiseStorage
import org.clustermc.lib.data.values.mutable.SettingData
import org.clustermc.lib.data.values.mutable.SettingDataValues.BooleanSetting
import org.clustermc.lib.player.storage.ClusterPlayer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class HubPlayer(playerId: UUID) extends ClusterPlayer(playerId) {

    val loginServer: SettingData[String] = SettingData("Hub", "Hub", classOf[String])
    val useRift = BooleanSetting(true, true)
    val boughtDisguises = new DisguiseStorage(playerId)
    var pvpClass: PvPClass = PvPClass.TANK

    override def toDocument: Document = {
        null //TODO
    }

    override def load(doc: Document): Unit = {
        //TODO
    }

    override def getIndex: String = HubPlayer.index

    override def getCollection: String = HubPlayer.collection

    override def getID: String = playerId.toString
}

object HubPlayer extends PlayerCoordinator[HubPlayer] {

    override def load(uuid: UUID): Unit = {
        //TODO
    }

}
