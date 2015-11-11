package org.clustermc.hub.hotbar.pages

import org.clustermc.hub.hotbar.items.{Air, PvpToggleSettings, ServerSelector}
import org.clustermc.hub.hotbar.items.Air

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object MainHubHotbar extends Hotbar(Array(Air, Air, Air, Air, ServerSelector, Air, Air, Air, PvpToggleSettings))
