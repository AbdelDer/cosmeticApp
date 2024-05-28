package ma.kader.cosmeticapp.presentation.add_edit_product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ma.kader.cosmeticapp.domain.model.Product
import ma.kader.cosmeticapp.presentation.add_edit_product.components.EditText
import ma.kader.cosmeticapp.presentation.add_edit_product.components.SubmitButton
import ma.kader.cosmeticapp.ui.theme.Dimens.defaultWeight
import ma.kader.cosmeticapp.ui.theme.Dimens.mediumPadding
import ma.kader.cosmeticapp.ui.theme.Dimens.smallPadding
import ma.kader.cosmeticapp.util.TempData.product

@Composable
fun AddEditProductScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(mediumPadding))
            EditText(text = product.title)
            Spacer(modifier = Modifier.height(mediumPadding))
            EditText(text = product.description)
        }
        Spacer(modifier = Modifier.weight(defaultWeight))
        SubmitButton(
            modifier = Modifier.padding(
                bottom = smallPadding
            )
        )
    }
}

@Preview
@Composable
fun AddEditProductScreenPreview() {
    AddEditProductScreen(navController = rememberNavController())
}