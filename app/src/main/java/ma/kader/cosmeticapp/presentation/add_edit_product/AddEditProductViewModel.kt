package ma.kader.cosmeticapp.presentation.add_edit_product

import androidx.lifecycle.ViewModel
import ma.kader.cosmeticapp.domain.repository.ProductRepository

class AddEditProductViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {
}