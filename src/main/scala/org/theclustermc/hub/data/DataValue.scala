package org.theclustermc.hub.data

import org.bson.Document
import org.theclustermc.hub.utils.database.MongoObject

trait DataValue[T] extends MongoObject {
    val name = this.getClass.getSimpleName.toLowerCase

    var _value: Option[T] = None

    override def getIndex: String = ???

    override def getCollection: String = ???

    override def getID: String = ???

    override def toDocument: Document = ???

    override def load(doc: Document): Unit = ???
}
