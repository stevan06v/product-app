package at.ac.product_app.data.remote
import at.ac.product_app.data.model.Product
import retrofit2.http.GET

interface ProductApiService {
    // für test auch post put update...
    @GET("products")
    suspend fun getProducts(): List<Product>
}
