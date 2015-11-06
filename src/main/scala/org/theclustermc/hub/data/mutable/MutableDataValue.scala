package org.theclustermc.hub.data.mutable

import org.theclustermc.hub.data.DataValue
import org.theclustermc.hub.utils.GenericOps.option

import scala.reflect.ClassTag

trait MutableDataValue[T] extends DataValue[T] {
    def value_=(value: T)(implicit tTag: ClassTag[T]) = _value = option(value)

}

class MutableDataValueImpl[T](private[this] override var value: Option[T]) extends MutableDataValue[T] {
    _value = value
}

object MutableDataValue {

    def apply[T: ClassTag](value: T) = {
        new MutableDataValueImpl(option(value))
    }
}

