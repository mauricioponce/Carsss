package cl.dal.cars.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.dal.cars.model.pojos.Repository
import kotlinx.coroutines.launch

class ListingViewModel: ViewModel() {

    private val repository = Repository()

    val carList = repository.carList()

    fun getCars() {
        viewModelScope.launch {
            repository.getCars()
        }
    }
}