package org.theclustermc.hub.player

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object Setting {
  sealed abstract class Settingg[T](val name: String, val defaultValue: T){}

  case object PVP extends Settingg[Boolean]("test", true)

  val settings: Set[Settingg] = EnumerationMacros.sealedInstancesOf[Settingg]

}
