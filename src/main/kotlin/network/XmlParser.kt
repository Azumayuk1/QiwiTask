package network

import org.simpleframework.xml.*

// Классы, получаемые из XML ответа
@Root(name = "ValCurs")
class ValCurs {
    @field:ElementList(inline = true, name = "Valute")
    var valutes: List<Valute>? = null

    @field:Attribute(name = "Date", required = false)
    var date: String? = null

    @field:Attribute(name = "name", required = false)
    var name: String? = null
}

// Вложенные элементы - валюты
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

