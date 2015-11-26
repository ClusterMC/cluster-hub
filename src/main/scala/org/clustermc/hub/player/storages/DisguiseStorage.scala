package org.clustermc.hub.player.storages

import java.util.UUID

import org.clustermc.hub.{DisguiseEnum, PurchaseResult}
import org.clustermc.lib.player.ClusterPlayer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class DisguiseStorage(uuid: UUID) {

    val disguises: Set[DisguiseEnum] = Set()

    def has(disguise: DisguiseEnum): Boolean = {
        disguises.contains(disguise)
    }

    /**
     *
     * @param disguise the disguise to buy
     * @return true if disguise purchase was successful
     */
    def buy(disguise: DisguiseEnum): PurchaseResult = {
        if(!has(disguise)){
            val bank = ClusterPlayer(uuid).bank.getClusterWallet
            if(bank.has(disguise.getCost)){
                bank.withdraw(disguise.getCost)
                PurchaseResult.SUCCESS
            }else
                PurchaseResult.INVALID_FUNDS
        }
        PurchaseResult.ALREADY_PURCHASED
    }

}
