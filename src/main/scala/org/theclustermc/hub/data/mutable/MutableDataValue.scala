package org.theclustermc.hub.data.mutable

import org.theclustermc.hub.data.DataValues.DataValue

case class MutableDataValue[T](private[this] override var value: Option[T]) extends DataValue[T] {

    def value_=(value: T) = {

        var option: Option[T] = None
        value match {
            case v: Some[T] => option = v
            case v: T => option = Option.apply(v)
            case _ => option = None
        }
        _value = option
    }
}

object MutableDataValue {

    def apply[T](value: T) = new MutableDataValue[T](Option.apply(value))
}

