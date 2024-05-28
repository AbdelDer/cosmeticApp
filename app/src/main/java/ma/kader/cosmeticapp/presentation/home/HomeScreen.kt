package ma.kader.cosmeticapp.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ma.kader.cosmeticapp.presentation.home.components.ProductItem
import ma.kader.cosmeticapp.presentation.util.Screen
import ma.kader.cosmeticapp.util.TempData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddEditProductScreen.route)
                },
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
            }
        },
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(50) { product ->
                ProductItem(product = TempData.product)
            }
        }
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    HomeScreen(rememberNavController())
}