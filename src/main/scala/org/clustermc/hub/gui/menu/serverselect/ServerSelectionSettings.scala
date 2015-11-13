package org.clustermc.hub.gui.menu.serverselect

import io.mazenmc.menuapi.menu.Menu
import org.clustermc.hub.gui.menu.serverselect.items.serversettings.{SkyWarsItem, Hub}
import org.clustermc.lib.utils.Done

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

@Done
object ServerSelectionSettings extends Menu("Server Login Chooser", 9){
  setItem(3, Hub)
  setItem(7, SkyWarsItem)
}
