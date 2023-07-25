package network

import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "http://www.cbr.ru/scripts/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    //.addConverterFactory(SimpleXml)
    .build()
interface CentralBankApi {
    //@GET("XML_daily.asp")
}

