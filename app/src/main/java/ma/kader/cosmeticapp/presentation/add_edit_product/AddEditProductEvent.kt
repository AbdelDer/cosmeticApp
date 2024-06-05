package ma.kader.cosmeticapp.presentation.add_edit_product

import androidx.compose.ui.focus.FocusState

sealed class AddEditProductEvent{
    data class EnteredTitle(val value: String): AddEditProductEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddEditProductEvent()
    data class EnteredDescription(val value: String): AddEditProductEvent()
    data class ChangeDescriptionFocus(val focusState: FocusState): AddEditProductEvent()
    data object SaveProduct: AddEditProductEvent()
}