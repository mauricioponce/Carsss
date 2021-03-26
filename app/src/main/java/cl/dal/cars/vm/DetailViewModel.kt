package cl.dal.cars.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.dal.cars.model.Repository
import cl.dal.cars.model.pojos.CarDetail

import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val repository = Repository()

    fun getDetail(id: String): LiveData<CarDetail> {
        viewModelScope.launch { repository.getCarDetail(id) }

        return repository.carDetail(id.toInt())
    }
}