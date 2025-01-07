import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.ac.product_app.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProducts()
                _products.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
