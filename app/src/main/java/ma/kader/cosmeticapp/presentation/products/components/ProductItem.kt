package ma.kader.cosmeticapp.presentation.products.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ma.kader.cosmeticapp.domain.model.Product
import ma.kader.cosmeticapp.presentation.util.Screen
import ma.kader.cosmeticapp.ui.theme.Dimens.defaultWeight
import ma.kader.cosmeticapp.ui.theme.Dimens.mediumPadding

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Row(
        modifier = modifier.padding(mediumPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(defaultWeight),
        ) {
            Text(text = product.title)
            Text(text = product.description)
        }
        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = "Edit Button",
            modifier = Modifier.clickable(
                onClick = {
                    navController.navigate(
                        Screen.AddEditProductScreen.route + "?productId=${product.id}"
                    )
                }
            )
        )
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(
        navController = rememberNavController(),
        product = Product(
            title = "This is a title",
            description = "This is a description",
            createdAt = 1716635476
        )
    )
}