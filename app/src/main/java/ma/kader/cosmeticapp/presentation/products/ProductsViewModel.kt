package ma.kader.cosmeticapp.presentation.products

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ma.kader.cosmeticapp.domain.repository.ProductRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job

class ProductsViewModel(
    private val productRepository: ProductRepository
): ViewModel() {

    private val _state = mutableStateOf(ProductState())
    val state: State<ProductState> = _state

    private var getProductsJob: Job? = null

    init {
        getProducts()
    }

    private fun getProducts() {
        getProductsJob?.cancel()
        getProductsJob = productRepository.getProducts().onEach { products ->
            _state.value = state.value.copy(
                products = products
            )
        }.launchIn(viewModelScope)
    }
}