package org.clustermc.hub.serverselect.menu

import io.mazenmc.menuapi.menu.Menu
import org.clustermc.hub.serverselect.menu.items.servers.SkyWarsItem

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object ServerSelectionMenu extends Menu("Where shall we go?", 27) {

    setItem(1, 4, SkyWarsItem)

}
