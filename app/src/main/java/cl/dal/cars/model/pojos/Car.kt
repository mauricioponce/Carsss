package cl.dal.cars.model.pojos

data class Car(
	val acceleration: String,
	val features: String,
	val name: String,
	val id: Int
)

/**
 * NOTA: Solo con fines pedagógicos
 */
data class CarDetail(
	val acceleration: String,
	val features: String,
	val name: String,
	val id: Int
)