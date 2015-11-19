package org.clustermc.hub.hotbar.hub

import org.clustermc.hub.hotbar.hub.items._
import org.clustermc.lib.gui.hotbar.{Air, Hotbar}

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object MainHubHotbar extends Hotbar(Array(Settings, Air, FunStuff, Air, ServerSelector, Air, Air, Air, PvpToggle))
