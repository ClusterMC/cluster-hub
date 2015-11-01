package org.theclustermc.hub.data.mutable

import org.theclustermc.hub.data.DataValues.DataValue
import org.theclustermc.hub.utils.GenericOps

import scala.reflect.ClassTag

trait MutableDataValue[T] extends DataValue[T] {
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

class MutableDataValueImpl[T](private[this] override var value: Option[T]) extends MutableDataValue[T] {
    _value = value
}

object MutableDataValue {

    def apply[T: ClassTag](value: T) = {
        new MutableDataValueImpl(GenericOps.optionWrap(value))
    }
}

