import kotlinx.coroutines.runBlocking
import network.CbApiService


fun main() {
    val usedApi = CbApiService.cbApiService

    // Запрос к АПИ в корутине
    runBlocking {
        val call = usedApi.getCbResponse("02/03/2002")
        println("Charcode: " + (call.valutes?.get(0)?.charCode))
        println("Value: " + (call.valutes?.get(0)?.value))
    }

}