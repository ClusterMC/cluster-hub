package org.theclustermc.hub.utils

import scala.reflect.ClassTag

object GenericOps {

    def optionWrap[A: ClassTag](x: A): Option[A] = x match {
        case a: Option[A] => a
        case a: A => Some(a)
        case _ => None
    }
}

