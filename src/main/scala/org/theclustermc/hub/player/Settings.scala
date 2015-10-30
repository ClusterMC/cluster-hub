package org.theclustermc.hub.player

import scala.collection.mutable.ArrayBuffer

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object Settings {

    sealed abstract class Setting[T](val name: String, private val default: T) {
        private val _default: Option[T] = Option.apply(default)
        private var _value: Option[T] = None

        def value = _value match {
            case x: Some[_] => _value
            case None => _default
        }

        def value_=(x: T): Unit = _value = Option.apply(x)

        def shouldSave = value.ne(_default)

        def print() = {
            println("==========")
            println(name)
            println(s"Default: ${_default.get}")
            println(s"Value: ${value.get}")
            println(s"Should Save: $shouldSave")
            println("==========")
        }


    }

    case class Flying() extends Setting("flying", true)

    case class Numbers() extends Setting[ArrayBuffer[Int]]("numbers", ArrayBuffer(1, 2, 3))

}
