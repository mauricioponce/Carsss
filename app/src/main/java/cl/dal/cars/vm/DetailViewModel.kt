package cl.dal.cars.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.dal.cars.model.pojos.Repository
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val repository = Repository()

    val carDetail = repository.carDetail()

    fun getDetail(id: String) {
        viewModelScope.launch { repository.getCarDetail(id) }
    }
}