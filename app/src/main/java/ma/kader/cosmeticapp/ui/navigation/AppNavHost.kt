package ma.kader.cosmeticapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ma.kader.cosmeticapp.CosmeticApplication
import ma.kader.cosmeticapp.di.viewModelFactory
import ma.kader.cosmeticapp.di.viewModelFactoryWithStateHandle
import ma.kader.cosmeticapp.presentation.add_edit_product.AddEditProductScreen
import ma.kader.cosmeticapp.presentation.add_edit_product.AddEditProductViewModel
import ma.kader.cosmeticapp.presentation.products.ProductsScreen
import ma.kader.cosmeticapp.presentation.products.ProductsViewModel
import ma.kader.cosmeticapp.presentation.util.Screen

@Composable
fun AppNavHost() {
    //NAVIGATION SETUP
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {

            val productsViewModel = viewModel<ProductsViewModel>(
                factory = viewModelFactory {
                    ProductsViewModel(CosmeticApplication.appModule.productRepository)
                }
            )

            ProductsScreen(
                productsViewModel = productsViewModel,
                navController = navController
            )
        }

        composable(
            route = Screen.AddEditProductScreen.route + "?productId={productId}",
            arguments = listOf(
                navArgument(
                    name = "productId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {

            val addEditProductViewModel = viewModel<AddEditProductViewModel>(
                factory = viewModelFactoryWithStateHandle { savedStateHandle ->
                    AddEditProductViewModel(
                        productRepository = CosmeticApplication.appModule.productRepository,
                        savedStateHandle = savedStateHandle
                    )
                }
            )

            AddEditProductScreen(
                navController = navController,
                addEditProductViewModel = addEditProductViewModel
            )
        }
    }
}