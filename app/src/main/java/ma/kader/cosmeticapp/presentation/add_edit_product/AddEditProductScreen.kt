package ma.kader.cosmeticapp.presentation.add_edit_product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ma.kader.cosmeticapp.presentation.add_edit_product.components.EditText
import ma.kader.cosmeticapp.presentation.add_edit_product.components.SubmitButton
import ma.kader.cosmeticapp.ui.theme.Dimens.defaultWeight
import ma.kader.cosmeticapp.ui.theme.Dimens.mediumPadding
import ma.kader.cosmeticapp.util.TempData.product

@Composable
fun AddEditProductScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    addEditProductViewModel: AddEditProductViewModel
) {
    val titleState = addEditProductViewModel.productTitle.value
    val descriptionState = addEditProductViewModel.productDescription.value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(mediumPadding))
            EditText(
                label = "Title",
                text = titleState.text,
                onValueChange = {
                    addEditProductViewModel.onEvent(
                        AddEditProductEvent.EnteredTitle(it)
                    )
                }
            )
            Spacer(modifier = Modifier.height(mediumPadding))
            EditText(
                label = "Description",
                text = descriptionState.text,
                onValueChange = {
                    addEditProductViewModel.onEvent(
                        AddEditProductEvent.EnteredDescription(it)
                    )
                }
            )
        }
        Spacer(modifier = Modifier.weight(defaultWeight))
        SubmitButton(
            modifier = Modifier.padding(
                bottom = mediumPadding
            ),
            onClick = {
                addEditProductViewModel.onEvent(AddEditProductEvent.SaveProduct)
                navController.navigateUp()
            }
        )
    }
}