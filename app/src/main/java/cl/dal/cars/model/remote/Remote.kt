package cl.dal.cars.model.remote

import cl.dal.cars.model.pojos.Car
import cl.dal.cars.model.pojos.CarDetail
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CarAPI {

   @GET("cars")
   suspend fun getCars(): Response<List<Car>>

   @GET("cars/{id}")
   suspend fun getCar(@Path("id") id: String): Response<CarDetail>
}


// Cliente retrofit
const val BASE_URL = "https://my-json-server.typicode.com/hakanovski/e28-project-2-api/"
class RetrofitClient {
    companion object {
        fun instance(): CarAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()

            return retrofit.create(CarAPI::class.java)
        }
    }
}