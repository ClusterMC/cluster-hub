package org.theclustermc.hub.rift

import java.util.UUID

import org.bukkit.{Bukkit, Location}
import org.bukkit.entity.Player
import org.theclustermc.hub.Hub
import org.theclustermc.hub.bungee.ServerTeleport
import org.theclustermc.hub.utils.math.LocationIterator

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object TeleportationRift {
  private final val openRifts: Map[UUID, (String, List[Location])] = Map()

  def open(player: Player, server: String): Unit = {

  }

  def use(uuid: UUID): Unit = {
    Bukkit.getScheduler.runTaskLater(Hub.instance, new Nothing() {
      @Override def run() = {
        ServerTeleport.tpToServer(Bukkit.getPlayer(uuid), get(uuid)._1)
        remove(uuid)
      }
    }, 1L)
  }

  def get(uuid: UUID) = openRifts.get(uuid).get
  def has(uuid: UUID) = openRifts.contains(uuid)
  def remove(uuid: UUID)= if(has(uuid)) openRifts - uuid

  def riftLocations(loc: Location): List[Location] = {
    val iter = new LocationIterator(loc.getWorld, loc.toVector, loc.clone.getDirection.setY(0), 0, 4)
    val finalBlocks: List[Location] = List()
    while(iter.hasNext) finalBlocks.::(iter.next().subtract(0,1,0))
    finalBlocks
  }

}
