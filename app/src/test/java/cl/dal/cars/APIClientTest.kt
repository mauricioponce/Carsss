package cl.dal.cars

import cl.dal.cars.model.remote.BASE_URL
import com.google.common.truth.Truth
import org.junit.Test

class APIClientTest {

    @Test
    fun baseUrl() {
        // Given
        val baseUrl = BASE_URL
        val expected = "https://my-json-server.typicode.com/hakanovski/e28-project-2-api/"

        // When

        // Then
        Truth.assertThat(baseUrl).isEqualTo(expected)
    }
}