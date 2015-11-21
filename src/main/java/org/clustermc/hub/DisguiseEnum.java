package org.clustermc.hub;
/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.clustermc.lib.utils.ItemFactory;

public enum DisguiseEnum {
    PIG("Bacon",
        Material.GRILLED_PORK,
        200,
        DisguiseType.PIG),

    COW("Burger",
        Material.COOKED_BEEF,
        150,
        DisguiseType.COW),

    MOOSHROOM("Mooooooshroom",
              Material.RED_MUSHROOM,
              150,
              DisguiseType.MUSHROOM_COW),

    ZOMBIE("Tom's Older Brother",
           Material.ROTTEN_FLESH,
           150,
           DisguiseType.ZOMBIE),

    ZOMBIE_VILLAGER("Tom's Father",
                    Material.WOOD,
                    150,
                    DisguiseType.ZOMBIE_VILLAGER),

    PIG_ZOMBIE("Tom's Estranged Cousin",
               Material.WOOD,
               150,
               DisguiseType.PIG_ZOMBIE),

    GIANT("Tom's Very.. Very Big Brother",
          Material.WOOD,
          20000,
          DisguiseType.GIANT),

    SPIDER("Creepy-Crawly",
           Material.WOOD,
           150,
           DisguiseType.SPIDER),

    CAVE_SPIDER("Minispider",
                Material.WOOD,
                150,
                DisguiseType.CAVE_SPIDER),

    BAT("Dracula",
        Material.WOOD,
        150,
        DisguiseType.BAT),

    BLAZE("The Redhead",
          Material.WOOD,
          150,
          DisguiseType.BLAZE),

    BOAT("A Boat, Yes... A Boat",
         Material.WOOD,
         7000,
         DisguiseType.BOAT),

    CHICKEN("McNuggets",
            Material.WOOD,
            150,
            DisguiseType.CHICKEN),

    CREEPER("Mr. Boom-Boom",
            Material.WOOD,
            150,
            DisguiseType.CREEPER),

    DONKEY("Kerfuffle",
           Material.WOOD,
           150,
           DisguiseType.DONKEY),

    ELDER_GUARDIAN("-----------",
                   Material.WOOD,
                   150,
                   DisguiseType.ELDER_GUARDIAN),

    ENDERMAN("Slender Man",
             Material.WOOD,
             150,
             DisguiseType.ENDERMAN),

    GHAST("-----------",
          Material.WOOD,
          6000,
          DisguiseType.GHAST),

    GUARDIAN("-----------",
             Material.WOOD,
             150,
             DisguiseType.GUARDIAN),

    HORSE("Sir Long-Face",
          Material.WOOD,
          150,
          DisguiseType.HORSE),

    UNDEAD_HORSE("Tom's Best Friend",
                 Material.WOOD,
                 150,
                 DisguiseType.UNDEAD_HORSE),

    MULE("Carrier Of Things & Objects",
         Material.WOOD,
         150,
         DisguiseType.MULE),

    SKELETON_HORSE("Bone's Best Friend",
                   Material.WOOD,
                   150,
                   DisguiseType.SKELETON_HORSE),

    MAGMA_CUBE("Angry Square",
               Material.WOOD,
               150,
               DisguiseType.MAGMA_CUBE),

    MINECART("Basic Minecart",
             Material.WOOD,
             650,
             DisguiseType.MINECART),

    MINECART_CHEST("Hoarder Minecart",
                   Material.WOOD,
                   150,
                   DisguiseType.MINECART_CHEST),

    MINECART_COMMAND("Techie Minecart",
                     Material.WOOD,
                     150,
                     DisguiseType.MINECART_COMMAND),

    MINECART_FURNACE("Burny-Flamey Minecart",
                     Material.WOOD,
                     150,
                     DisguiseType.MINECART_FURNACE),

    MINECART_HOPPER("Picker-Upper Minercart",
                    Material.WOOD,
                    150,
                    DisguiseType.MINECART_HOPPER),

    MINECART_MOB_SPAWNER("Birthing Minecart",
                         Material.WOOD,
                         150,
                         DisguiseType.MINECART_MOB_SPAWNER),

    MINECART_TNT("Explodey Minecart",
                 Material.WOOD,
                 150,
                 DisguiseType.MINECART_TNT),

    IRON_GOLEM("-----------",
               Material.WOOD,
               150,
               DisguiseType.IRON_GOLEM),

    OCELOT("Cat Thing",
           Material.WOOD,
           150,
           DisguiseType.OCELOT),

    PRIMED_TNT("Almost-Splodey TNT",
               Material.WOOD,
               150,
               DisguiseType.PRIMED_TNT),

    RABBIT("Bugs Bunny",
           Material.WOOD,
           150,
           DisguiseType.RABBIT),

    SHEEP("Mutton",
          Material.WOOD,
          150,
          DisguiseType.SHEEP),

    SILVERFISH("-----------",
               Material.WOOD,
               150,
               DisguiseType.SILVERFISH),

    SKELETON("Bones",
             Material.WOOD,
             150,
             DisguiseType.SKELETON),

    WITHER("Bone's Father, Mother, And...",
           Material.WOOD,
           150,
           DisguiseType.WITHER),

    WITHER_SKELETON("Bone's Older Sister",
                    Material.WOOD,
                    150,
                    DisguiseType.WITHER_SKELETON),

    SLIME("Vegetarian Square",
          Material.WOOD,
          150,
          DisguiseType.SLIME),

    WOLF("Jacob Black",
         Material.WOOD,
         150,
         DisguiseType.WOLF),

    WITCH("Sarah Good",
          Material.WOOD,
          150,
          DisguiseType.WITCH),

    VILLAGER("Newscaster",
             Material.WOOD,
             150,
             DisguiseType.VILLAGER),

    SQUID("Squid the 16-bit Butcher",
          Material.WOOD,
          9001,
          DisguiseType.SQUID);

    private String       name;
    private Material     material;
    private int          cost;
    private DisguiseType type;

    DisguiseEnum(String name, Material material, int cost, DisguiseType type) {
        this.name = name;
        this.material = material;
        this.cost = cost;
        this.type = type;
    }

    public ItemStack itemstack() {
        return new ItemFactory(getMaterial())
                .setDisplayName(getName())
                .setLore(0, this.name())
                .getItemStack();
    }

    public String getName() {return this.name;}

    public Material getMaterial() {return this.material;}

    public int getCost() {return this.cost;}

    public DisguiseType getType() {return this.type;}
}
