package org.clustermc.hub.gui.hotbar.pages

import org.clustermc.hub.gui.hotbar.items.main.{PvpToggle, ServerSelector}
import org.clustermc.hub.gui.hotbar.items.misc.Air

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object MainHubHotbar extends Hotbar(Array(Air, Air, Air, Air, ServerSelector, Air, Air, Air, PvpToggle))
