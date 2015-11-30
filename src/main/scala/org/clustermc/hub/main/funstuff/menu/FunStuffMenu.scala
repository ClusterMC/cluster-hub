package org.clustermc.hub.main.funstuff.menu

import io.mazenmc.menuapi.menu.Menu
import org.clustermc.hub.main.funstuff.menu.items.{DisguiseSubItem, GadgetsSubItem, MountsSubItem, ParticlesSubItem}

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object FunStuffMenu extends Menu("Fun Stuff", 36) {
    setItem(1, DisguiseSubItem)
    setItem(2, GadgetsSubItem)
    setItem(3, MountsSubItem)
    setItem(4, ParticlesSubItem)
}
