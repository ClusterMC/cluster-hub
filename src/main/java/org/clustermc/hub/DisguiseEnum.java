package org.clustermc.hub;
/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

import lombok.Getter;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;

public @Getter enum DisguiseEnum {
    PIG("Porky-Pig", 5, 200, DisguiseType.PIG),
    COW("Bacon", 5, 150, DisguiseType.COW),
    MOOSHROOM("Bacon", 5, 150, DisguiseType.MUSHROOM_COW),
    ZOMBIE("Bacon", 5, 150, DisguiseType.WOLF),
    ZOMBIE_VILLAGER("Bacon", 5, 150, DisguiseType.WOLF);




    private String name;
    private int datavalue;
    private int cost;
    private DisguiseType type;

    DisguiseEnum(String name, int datavalue, int cost, DisguiseType type) {
        this.name = name;
        this.datavalue = datavalue;
        this.cost = cost;
        this.type = type;
    }
}
