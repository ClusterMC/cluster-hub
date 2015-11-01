package org.theclustermc.hub.data.mutable

import org.theclustermc.hub.data.DataValues.DefaultDataValue

case sealed class SettingData[T](private[this] val default: Option[T])
    extends MutableDataValue[T](default) with DefaultDataValue[T] {

    override val _default = default
}

object SettingData {

    def apply[T](value: T) = new SettingData(Option.apply(value))
}
