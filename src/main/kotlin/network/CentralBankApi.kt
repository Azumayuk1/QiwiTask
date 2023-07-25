package network

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://www.cbr.ru/scripts/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(SimpleXmlConverterFactory.create())
    .build()

// Интерфейс для запросов
interface CentralBankApi {
    @GET("XML_daily.asp")
    suspend fun getCbResponse(
        @Query("date_req") date: String
    ): ValCurs
}

// Синглтон для АПИ
object CbApiService {
    val cbApiService = retrofit.create(CentralBankApi::class.java)
}

