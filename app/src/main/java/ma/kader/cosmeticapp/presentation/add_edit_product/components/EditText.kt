package ma.kader.cosmeticapp.presentation.add_edit_product.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ma.kader.cosmeticapp.ui.theme.Dimens
import ma.kader.cosmeticapp.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(
    modifier: Modifier = Modifier,
    text: String
) {
    TextField(
        value = text,
        onValueChange = { },
        textStyle = Typography.labelSmall,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.mediumPadding)
    )
}