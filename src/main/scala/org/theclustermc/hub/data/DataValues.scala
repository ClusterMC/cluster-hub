package org.theclustermc.hub.data

import org.bson.Document
import org.theclustermc.hub.utils.database.MongoObject

object DataValues {

    trait DataValue[T] extends MongoObject {
        val name = this.getClass.getSimpleName.toLowerCase

        private[data] var _value: Option[T] = None

        def value = _value

        def serialize = if(_value.isDefined) Some(_value.toString) else None

        def deserialize(t: String) = this

        override def getIndex: String = ???

        override def getCollection: String = ???

        override def getID: String = ???

        override def toDocument: Document = {
            val document = new Document()
            val serialized = serialize

            if(serialized.isDefined) {
                document.append(name, serialized.get)
            }
            document
        }

        override def load(doc: Document): Unit = ???


    }

    trait DefaultDataValue[T] extends DataValue[T] {
        private[data] val _default: Option[T]

        def isDefault = value.equals(_default)

        def print() = {
            println(toDocument.toJson)
        }

        override def toDocument: Document = {
            super.toDocument.append("isDefault", isDefault)
        }
    }
}
