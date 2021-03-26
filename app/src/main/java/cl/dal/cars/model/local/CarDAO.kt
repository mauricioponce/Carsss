package cl.dal.cars.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.dal.cars.model.pojos.Car
import cl.dal.cars.model.pojos.CarDetail

@Dao
interface CarDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(carList: List<Car>)

    @Query("SELECT * FROM car")
    fun getCars(): LiveData<List<Car>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(carDetail: CarDetail)

    @Query("SELECT * FROM cardetail WHERE id=:id")
    fun getCarById(id: Int): LiveData<CarDetail>
}