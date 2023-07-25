package network

import org.simpleframework.xml.*
import org.simpleframework.xml.core.Persister

class XmlParser {
    val serializer: Serializer = Persister()
    //val dataFetch = serializer.read(ValCurs::class.java)
}

// Классы, получаемые из XML ответа
@Root(name = "ValCurs")
class ValCurs {
    @field:ElementList(inline = true, name = "Valute")
    var valutes: List<Valute>? = null

    @field:Attribute(name = "Date")
    var date: String? = null

    @field:Attribute(name = "name")
    var name: String? = null
}

@Root(name = "Valute")
class Valute{
    @field:Attribute(name = "ID")
    var id: String? = null

    @field:Element(name = "NumCode")
    var numCode: String? = null

    @field:Element(name = "CharCode")
    var charCode: String? = null

    @field:Element(name = "Nominal")
    var nominal: String? = null

    @field:Element(name = "Name")
    var name: String? = null

    @field:Element(name = "Value")
    var value: String? = null
}

