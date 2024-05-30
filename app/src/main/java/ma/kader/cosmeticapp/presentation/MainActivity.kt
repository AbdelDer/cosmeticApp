package ma.kader.cosmeticapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ma.kader.cosmeticapp.CosmeticApplication
import ma.kader.cosmeticapp.di.viewModelFactory
import ma.kader.cosmeticapp.presentation.add_edit_product.AddEditProductScreen
import ma.kader.cosmeticapp.presentation.products.ProductsScreen
import ma.kader.cosmeticapp.presentation.products.ProductsViewModel
import ma.kader.cosmeticapp.presentation.util.Screen
import ma.kader.cosmeticapp.ui.theme.CosmeticAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CosmeticAppTheme {
                val productsViewModel = viewModel<ProductsViewModel>(
                    factory = viewModelFactory {
                        ProductsViewModel(CosmeticApplication.appModule.productRepository)
                    }
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //NAVIGATION SETUP
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
                        composable(route = Screen.HomeScreen.route) {
                            ProductsScreen(
                                productsViewModel= productsViewModel,
                                navController = navController
                            )
                        }

                        composable(route = Screen.AddEditProductScreen.route) {
                            AddEditProductScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}