package ma.kader.cosmeticapp.presentation.add_edit_product

data class ProductTextFieldState (
        val text: String = "",
        val hint: String = "",
        val isHintVisible: Boolean = true
    )