package cl.dal.cars.model.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.dal.cars.model.pojos.Car
import cl.dal.cars.model.pojos.CarDetail
import timber.log.Timber

@Database(entities = [Car::class, CarDetail::class], version = 1)
abstract class CarDatabase : RoomDatabase() {
    abstract fun carDao(): CarDAO
}

class CarApplication : Application() {
    companion object {
        var carDatabase: CarDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        Timber.d("onCreate de Application")
        carDatabase =
            Room.databaseBuilder(this, CarDatabase::class.java, "db_cars").build()
    }
}