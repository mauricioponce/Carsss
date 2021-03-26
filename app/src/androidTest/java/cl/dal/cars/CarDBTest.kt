package cl.dal.cars

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import cl.dal.cars.model.local.CarDAO
import cl.dal.cars.model.local.CarDatabase
import cl.dal.cars.model.pojos.Car
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After

import org.junit.Test

import org.junit.Before
import org.junit.Rule

class CarDBTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Instancias de DAO y database
    private lateinit var cDao: CarDAO
    private lateinit var db: CarDatabase


    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, CarDatabase::class.java).build()
        cDao = db.carDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertCar_empty() = runBlocking {
        // Given
        val countryList = listOf<Car>()

        // When
        cDao.insert(countryList)

        // Then
        cDao.getCars().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isEmpty()
        }
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertThat(appContext.packageName).isEqualTo("cl.dal.cars")
    }
}