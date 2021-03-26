package cl.dal.cars.model

import androidx.lifecycle.LiveData
import cl.dal.cars.model.local.CarApplication
import cl.dal.cars.model.pojos.Car
import cl.dal.cars.model.pojos.CarDetail
import cl.dal.cars.model.remote.RetrofitClient
import timber.log.Timber

class Repository {

    private val carAPI = RetrofitClient.instance()

    private val carDao = CarApplication.carDatabase!!.carDao()

    fun carList(): LiveData<List<Car>> = carDao.getCars()

    fun carDetail(id: Int): LiveData<CarDetail> = carDao.getCarById(id)

    suspend fun getCars(){
        val response = carAPI.getCars()
        when(response.isSuccessful) {
            true -> {
                if(response.body() != null) {
                    carDao.insert(response.body()!!)
                } else {
                    Timber.d("El body está empty")
                }
            }
            false -> {
                Timber.d("no tenemos respuesta de la api ${response.code()}")
            }
        }
    }

    suspend fun getCarDetail(id: String) {
        val response = carAPI.getCar(id)
        when(response.isSuccessful) {
            true -> {
                if(response.body() != null) {
                    Timber.d("epa! tenemos detalle ${response.body()}")
                    carDao.insert(response.body()!!)
                } else {
                    Timber.d("El body está empty para el detalle")
                }
            }

            false -> {
                Timber.d("no tenemos respuesta de la api para el detalle ${response.code()}")
            }
        }
    }

}