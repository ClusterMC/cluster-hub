package org.clustermc.hub.player

import java.util.UUID

import org.bson.Document
import org.clustermc.hub.{DisguiseEnum, Hub, PvPClass}
import org.clustermc.lib.data.mutable.{BooleanSetting, MutableListDataValueImpl, SettingData}
import org.clustermc.lib.econ.Bank
import org.clustermc.lib.utils.Coordinator
import org.clustermc.lib.utils.database.{MongoObject, PlayerWrapper}

import scala.collection.mutable.ArrayBuffer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class HubPlayer(playerId: UUID) extends PlayerWrapper(playerId) with MongoObject{

  val loginServer: SettingData[String] = SettingData("Hub", "Hub", classOf[String])
  val chatMention, useRift, showPlayers, receiveMessages = BooleanSetting(true, true)

  val boughtDisguises = new MutableListDataValueImpl[DisguiseEnum](
    Option(ArrayBuffer(Option(DisguiseEnum))),
    classOf[DisguiseEnum])

  var pvpClass: PvPClass = PvPClass.TANK



  val bank: Bank = null

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

object HubPlayer extends Coordinator[UUID, HubPlayer, UUID]{
  val index = "uuid"
  val collection = "playerdata"

  override def unload(key: UUID): Unit = {
    get(key).save(Hub.instance.database)
    remove(key)
  }

  override def unloadAll(): Unit = {
    coordinatorMap.keySet().forEach{
      case(key) => get(key).save(Hub.instance.database)
    }
    coordinatorMap.clear()
  }

  override def get(uuid: UUID): HubPlayer = {
    if(!has(uuid)) load(uuid)
    super.get(uuid)
  }

  override def load(uuid: UUID): Unit = {
    new HubPlayer(uuid).load(
      Hub.instance.database.getCollections.getCollection(collection)
        .find(new Document(index, uuid.toString))
        .first()
      )
  }
}
