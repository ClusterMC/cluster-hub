package org.clustermc.hub.player

import java.util.UUID

import org.clustermc.hub.DisguiseEnum

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class DisguisePurchaseManager(uuid: UUID) {

  val disguises: Set[DisguiseEnum] = Set()

  def has(disguise: DisguiseEnum): Boolean = {
    disguises.contains(disguise)
  }

  def buy(disguise: DisguiseEnum): Boolean = {
    HubPlayer.get(uuid).bank.getClusterWallet.withdraw(disguise.getCost)
  }

}
