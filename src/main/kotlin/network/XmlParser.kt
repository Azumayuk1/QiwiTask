package network

import org.simpleframework.xml.*
import org.simpleframework.xml.core.Persister

class XmlParser {
    val serializer: Serializer = Persister()
    //val dataFetch = serializer.read(ValCurs::class.java)
}

// Классы из XML ответа
@Root(name = "ValCurs")
class ValCurs {
    @field:Element(name = "Valute", required=false)
    lateinit var listValute: List<Valute>
}

@Root(name = "Valute")
class Valute {
    @field:Attribute(name = "CharCode")
    var charCode: String? = null

    @field:Attribute(name = "Value")
    var value: String? = null
}