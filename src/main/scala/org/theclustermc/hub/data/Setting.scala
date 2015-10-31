package org.theclustermc.hub.data

sealed class Setting[T](private val _default: Option[T]) extends DataValue[T] {

    def this(_default: T) = this(Option.apply(_default))

    private var _value: Option[T] = None

    def value = _value match {
        case Some(setting) => _value
        case None => _default
    }

    def value_=(value: Option with T): Unit = {
        var option: Option[T] = _
        value match {
            case v: Option[T] => option = v
            case v: T => option = Option.apply(v)
        }
        _value = option
    }

    def isDefault = value.eq(_default)
}
