package cl.dal.cars.model.pojos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Car(
	val acceleration: String,
	val features: String,
	val name: String,
	@PrimaryKey val id: Int
)

/**
 * NOTA: Solo con fines pedagógicos
 */
@Entity
data class CarDetail(
	val acceleration: String,
	val features: String,
	val name: String,
	@PrimaryKey val id: Int
)