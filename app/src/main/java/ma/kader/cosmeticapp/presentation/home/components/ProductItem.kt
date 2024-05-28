package ma.kader.cosmeticapp.presentation.home.components

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
import ma.kader.cosmeticapp.domain.model.Product
import ma.kader.cosmeticapp.ui.theme.Dimens.defaultWeight
import ma.kader.cosmeticapp.ui.theme.Dimens.mediumPadding

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(mediumPadding),
        verticalAlignment= Alignment.CenterVertically
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
        )
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(
        product = Product(
            title = "This is a title",
            description = "This is a description",
            createdAt = 1716635476
        )
    )
}