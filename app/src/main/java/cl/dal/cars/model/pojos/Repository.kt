package cl.dal.cars.model.pojos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timber.log.Timber

class Repository {

    private val carAPI = RetrofitClient.instance()

    private val carList = MutableLiveData<List<Car>>()
    fun carList(): LiveData<List<Car>> = carList

    private val carDetail = MutableLiveData<CarDetail>()
    fun carDetail(): LiveData<CarDetail> = carDetail

    suspend fun getCars(){
        val response = carAPI.getCars()
        when(response.isSuccessful) {
            true -> {
                if(response.body() != null) {
                    carList.value = response.body()
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
                    carDetail.value = response.body()
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