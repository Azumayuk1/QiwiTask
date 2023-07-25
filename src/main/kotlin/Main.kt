import kotlinx.coroutines.runBlocking
import network.CbApiService
import network.Valute
import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun main() {
    val args: Array<String> = readln().split(" ").toTypedArray()

    val codeIndex = args.indexOf("--code")
    val dateIndex = args.indexOf("--date")

    if (codeIndex == -1 || dateIndex == -1) {
        println("Команда набрана неправильно. Пример: currency_rates --code <3-значный код> --date <Дата в формате yyyy-MM-dd>")
        return
    }

    // Нахождение кода валюты и даты
    val code = args[codeIndex + 1]
    val dateString = args[dateIndex + 1]


    // Получение даты в формате для запроса к банку
    val date = try {
        LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE)
    } catch (e: Exception) {
        println("Неправильный формат даты. Используйте формат yyyy-MM-dd.")
        return
    }

    val day = if (date.dayOfMonth.toString().length == 1) {
        "0" + date.dayOfMonth
    } else {
        date.dayOfMonth
    }


    val usedApi = CbApiService.cbApiService
    // Запрос к АПИ в корутине
    runBlocking {
        val call = usedApi.getCbResponse("${day}/${date.month.value}/${date.year}")

        var requestedValute: Valute? = null

        // Нахождение кода
        for(i in call.valutes!!) {
            if(i.charCode == code) {
                requestedValute = i
            }
        }

        println("${requestedValute?.charCode}(${requestedValute?.name}): ${requestedValute?.value}")
    }

}
