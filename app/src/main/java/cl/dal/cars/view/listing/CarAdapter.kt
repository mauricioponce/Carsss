package cl.dal.cars.view.listing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.dal.cars.databinding.CarItemListBinding
import cl.dal.cars.model.pojos.Car


class CarAdapter: RecyclerView.Adapter<CarVH>() {

    private val selected = MutableLiveData<Car>()

    fun selected() : LiveData<Car> = selected

    private val carList = mutableListOf<Car>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarVH {
        val binding = CarItemListBinding.inflate(LayoutInflater.from(parent.context))

        return CarVH(binding)
    }

    override fun onBindViewHolder(holder: CarVH, position: Int) {
        val car = carList[position]

        holder.bind(car)
        holder.itemView.setOnClickListener {
            selected.value = car
        }
    }

    override fun getItemCount() = carList.size

    fun update(newCarList: List<Car>) {
        carList.clear()
        carList.addAll(newCarList)
        notifyDataSetChanged()
    }
}

class CarVH(val binding: CarItemListBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(car: Car) {
        binding.tvCarName.text = car.name
        binding.tvCarAcce.text = car.acceleration
    }
}