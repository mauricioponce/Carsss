package cl.dal.cars

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import cl.dal.cars.model.pojos.Car
import cl.dal.cars.model.remote.CarAPI
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class CarAPITest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var mockWebServer: MockWebServer

    private lateinit var service: CarAPI

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CarAPI::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun carList() = runBlocking {
        // Given
        val resultList = listOf(Car("2.4 seconds", "many features", "cobra kai", 1))
        mockWebServer.enqueue(MockResponse().setBody(Gson().toJson(resultList)))

        // When
        val result = service.getCars()

        // Then
        assertThat(result).isNotNull()
        assertThat(result.isSuccessful).isTrue()

        val message = result.body()
        assertThat(message).isNotNull()
        assertThat(message).hasSize(1)
    }
}