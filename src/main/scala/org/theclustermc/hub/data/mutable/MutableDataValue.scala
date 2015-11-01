package org.theclustermc.hub.data.mutable

import org.theclustermc.hub.data.DataValues.DataValue

class MutableDataValue[T](override var value: Option[T]) extends DataValue[T] {

    def value_=[V >: T with Option[T]](value: V) = {

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

