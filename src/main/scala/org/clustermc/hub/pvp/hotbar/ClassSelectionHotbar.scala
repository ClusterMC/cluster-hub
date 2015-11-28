package org.clustermc.hub.pvp.hotbar

import org.clustermc.hub.main.hotbar.ReturnToMain
import org.clustermc.hub.pvp.hotbar.items.{ArcherSelection, TankSelection}
import org.clustermc.lib.gui.hotbar.{Air, Hotbar}

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object ClassSelectionHotbar extends Hotbar(Array(ReturnToMain, Air, Air, TankSelection, Air, ArcherSelection, Air, Air, Air))
