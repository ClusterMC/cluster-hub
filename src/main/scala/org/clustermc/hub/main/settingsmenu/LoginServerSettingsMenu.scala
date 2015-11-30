package org.clustermc.hub.main.settingsmenu

import io.mazenmc.menuapi.menu.Menu
import org.clustermc.hub.main.settingsmenu.items.serversettings.{HubItem, SkyWarsItem}
import org.clustermc.hub.main.settingsmenu.items.submenuitems.SettingsMenuItem

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Default (Template) Project.
 * 
 * Default (Template) Project can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object LoginServerSettingsMenu extends Menu("Login Server", 9) {
    setItem(4, HubItem)
    setItem(6, SkyWarsItem)

    setItem(1, SettingsMenuItem)
}
