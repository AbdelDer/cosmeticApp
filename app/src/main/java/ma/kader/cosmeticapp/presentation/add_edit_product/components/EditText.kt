package ma.kader.cosmeticapp.presentation.add_edit_product.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ma.kader.cosmeticapp.ui.theme.Dimens
import ma.kader.cosmeticapp.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = text,
        label= { Text(label) },
        onValueChange = onValueChange,
        textStyle = Typography.labelMedium,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.mediumPadding)
    )
}