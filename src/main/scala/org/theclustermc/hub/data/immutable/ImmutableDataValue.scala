package org.theclustermc.hub.data.immutable

import org.theclustermc.hub.data.DataValues.DataValue

class ImmutableDataValue[T](private val _default: Option[T]) extends DataValue[T]

object ImmutableDataValue {

    def apply[T](value: T) = new ImmutableDataValue(Option.apply(value))
}
