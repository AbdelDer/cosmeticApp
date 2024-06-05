package ma.kader.cosmeticapp.presentation.add_edit_product

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ma.kader.cosmeticapp.domain.model.Product
import ma.kader.cosmeticapp.domain.repository.ProductRepository
import java.lang.Exception

class AddEditProductViewModel(
    private val productRepository: ProductRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _productTitle = mutableStateOf(ProductTextFieldState(
        hint = "Enter title..."
    ))
    val productTitle: State<ProductTextFieldState> = _productTitle

    private val _productDescription = mutableStateOf(ProductTextFieldState(
        hint = "Enter some content"
    ))
    val productDescription: State<ProductTextFieldState> = _productDescription

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentProductId: Int? = null

    init {
        savedStateHandle.get<Int>("productId")?.let { productId ->
            if(productId != -1) {
                viewModelScope.launch {
                    productRepository.getProductById(productId)?.also { product ->
                        currentProductId = product.id
                        _productTitle.value = productTitle.value.copy(
                            text = product.title,
                            isHintVisible = false
                        )
                        _productDescription.value = _productDescription.value.copy(
                            text = product.description,
                            isHintVisible = false
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: AddEditProductEvent) {
        when(event) {
            is AddEditProductEvent.EnteredTitle -> {
                _productTitle.value = productTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditProductEvent.ChangeTitleFocus -> {
                _productTitle.value = productTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            productTitle.value.text.isBlank()
                )
            }
            is AddEditProductEvent.EnteredDescription -> {
                _productDescription.value = productDescription.value.copy(
                    text = event.value
                )
            }
            is AddEditProductEvent.ChangeDescriptionFocus -> {
                _productDescription.value = productDescription.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            productDescription.value.text.isBlank()
                )
            }
            is AddEditProductEvent.SaveProduct -> {
                viewModelScope.launch {
                    try {
                        productRepository.insertProduct(
                            product = Product(
                                title = productTitle.value.text,
                                description = productDescription.value.text,
                                createdAt= System.currentTimeMillis(),
                                id = currentProductId
                            )
                        )
                    } catch (e : Exception) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Couldn't save product"
                            )
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        data object SaveProduct: UiEvent()
    }
}