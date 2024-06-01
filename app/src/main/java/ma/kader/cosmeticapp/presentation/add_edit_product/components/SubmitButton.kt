package ma.kader.cosmeticapp.presentation.add_edit_product.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ma.kader.cosmeticapp.R
import ma.kader.cosmeticapp.ui.theme.Dimens.smallPadding

@Composable
fun SubmitButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(smallPadding),
        onClick = onClick,
    ) {
        Text(text = stringResource(id = R.string.submit))
    }
}


@Preview
@Composable
fun SubmitButtonPreview() {
    SubmitButton(onClick = {})
}