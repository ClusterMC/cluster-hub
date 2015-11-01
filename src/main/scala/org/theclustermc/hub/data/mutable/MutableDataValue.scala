package org.theclustermc.hub.data.mutable

import org.theclustermc.hub.data.DataValues.DataValue
import org.theclustermc.hub.utils.GenericOps

import scala.reflect.ClassTag
import scala.language.implicitConversions

trait MutableDataValue[T] extends DataValue[T] {
    def value_=(value: T)(implicit tTag: ClassTag[T]) = _value = GenericOps.optionWrap(value)

}

class MutableDataValueImpl[T](private[this] override var value: Option[T]) extends MutableDataValue[T] {
    _value = value
}

object MutableDataValue {

    def apply[T: ClassTag](value: T) = {
        new MutableDataValueImpl(GenericOps.optionWrap(value))
    }
}

