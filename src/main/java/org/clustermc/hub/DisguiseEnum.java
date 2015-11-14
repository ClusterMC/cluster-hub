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
import org.bukkit.Material;

public @Getter enum DisguiseEnum {
    PIG("Bacon", Material.GRILLED_PORK, 200, DisguiseType.PIG),
    COW("Burger", Material.COOKED_BEEF, 150, DisguiseType.COW),
    MOOSHROOM("Mooooooshroom", Material.RED_MUSHROOM, 150, DisguiseType.MUSHROOM_COW),
    ZOMBIE("Tom's Older Brother", Material.ROTTEN_FLESH, 150, DisguiseType.ZOMBIE),
        ZOMBIE_VILLAGER("Tom's Father", 5, 150, DisguiseType.ZOMBIE_VILLAGER),
        PIG_ZOMBIE("Tom's Estranged Cousin", 5, 150, DisguiseType.PIG_ZOMBIE),
        GIANT("Tom's Very.. Very Big Brother", 5, 20000, DisguiseType.GIANT),
    SPIDER("Creepy-Crawly", 5, 150, DisguiseType.SPIDER),
        CAVE_SPIDER("Minispider", 5, 150, DisguiseType.CAVE_SPIDER),
    BAT("Dracula", 5, 150, DisguiseType.BAT),
    BLAZE("The Redhead", 5, 150, DisguiseType.BLAZE),
    BOAT("A Boat, Yes... A Boat", 5, 7000, DisguiseType.BOAT),
    CHICKEN("McNuggets", 5, 150, DisguiseType.CHICKEN),
    CREEPER("Mr. Boom-Boom", 5, 150, DisguiseType.CREEPER),
    DONKEY("Kerfuffle", 5, 150, DisguiseType.DONKEY),
    ELDER_GUARDIAN("-----------", 5, 150, DisguiseType.ELDER_GUARDIAN),
    ENDERMAN("Slender Man", 5, 150, DisguiseType.ENDERMAN),
    GHAST("-----------", 5, 6000, DisguiseType.GHAST),
    GUARDIAN("-----------", 5, 150, DisguiseType.GUARDIAN),
    HORSE("Sir Long-Face", 5, 150, DisguiseType.HORSE),
        UNDEAD_HORSE("Tom's Best Friend", 5, 150, DisguiseType.UNDEAD_HORSE),
        MULE("Carrier Of Things & Objects", 5, 150, DisguiseType.MULE),
        SKELETON_HORSE("Bone's Best Friend", 5, 150, DisguiseType.SKELETON_HORSE),
    MAGMA_CUBE("Angry Square", 5, 150, DisguiseType.MAGMA_CUBE),
    MINECART("Basic Minecart", 5, 650, DisguiseType.MINECART),
        MINECART_CHEST("Hoarder Minecart", 5, 150, DisguiseType.MINECART_CHEST),
        MINECART_COMMAND("Techie Minecart", 5, 150, DisguiseType.MINECART_COMMAND),
        MINECART_FURNACE("Burny-Flamey Minecart", 5, 150, DisguiseType.MINECART_FURNACE),
        MINECART_HOPPER("Picker-Upper Minercart", 5, 150, DisguiseType.MINECART_HOPPER),
        MINECART_MOB_SPAWNER("Birthing Minecart", 5, 150, DisguiseType.MINECART_MOB_SPAWNER),
        MINECART_TNT("Explodey Minecart", 5, 150, DisguiseType.MINECART_TNT),
    IRON_GOLEM("-----------", 5, 150, DisguiseType.IRON_GOLEM),
    OCELOT("Cat Thing", 5, 150, DisguiseType.OCELOT),
    PRIMED_TNT("Almost-Splodey TNT", 5, 150, DisguiseType.PRIMED_TNT),
    RABBIT("Bugs", 5, 150, DisguiseType.RABBIT),
    SHEEP("Mutton", 5, 150, DisguiseType.SHEEP),
    SILVERFISH("-----------", 5, 150, DisguiseType.SILVERFISH),
    SKELETON("Bones", 5, 150, DisguiseType.SKELETON),
    WITHER("Bone's Father, Mother, And...", 5, 150, DisguiseType.WITHER),
    WITHER_SKELETON("Bone's Older Sister", 5, 150, DisguiseType.WITHER_SKELETON),
    SLIME("Vegetarian Square", 5, 150, DisguiseType.SLIME),
    WOLF("Jacob Black", 5, 150, DisguiseType.WOLF),
    WITCH("Sarah Good", 5, 150, DisguiseType.WITCH),
    VILLAGER("Newscaster", 5, 150, DisguiseType.VILLAGER),

    SQUID("Squid", 5, 9001, DisguiseType.SQUID);

    private String name;
    private Material datavalue;
    private int cost;
    private DisguiseType type;

    DisguiseEnum(String name, Material datavalue, int cost, DisguiseType type) {
        this.name = name;
        this.datavalue = datavalue;
        this.cost = cost;
        this.type = type;
    }
}
