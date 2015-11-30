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

    var disguises: Set[DisguiseEnum] = Set()

    var doubClick = ()

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
                unlock(disguise)
                PurchaseResult.SUCCESS
            }else
                PurchaseResult.INVALID_FUNDS
        }
        PurchaseResult.ALREADY_PURCHASED
    }

    private def unlock(disguise: DisguiseEnum): Boolean ={
        if(!has(disguise)){
            disguises += disguise
            return true
        }
        false
    }

    def deserialize(input: String): Unit ={
        if(input != "none"){
            input.split(";").foreach(s => unlock(DisguiseEnum.valueOf(s)))
        }
    }

    def serialize(): String ={
        var string: String = ""
        disguises.foreach(x => string += (x.name() + ";"))
        if(string.length > 1){
            string = new StringBuffer(string).deleteCharAt(string.length - 1).toString
        }else{
            string = "none"
        }
        string
    }

}
