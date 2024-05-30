package ma.kader.cosmeticapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ma.kader.cosmeticapp.presentation.add_edit_product.AddEditProductScreen
import ma.kader.cosmeticapp.presentation.add_edit_product.AddEditProductViewModel
import ma.kader.cosmeticapp.presentation.products.ProductsScreen
import ma.kader.cosmeticapp.presentation.products.ProductsViewModel
import ma.kader.cosmeticapp.presentation.util.Screen

@Composable
fun AppNavHost(
    productsViewModel: ProductsViewModel,
    addEditProductViewModel: AddEditProductViewModel
) {
    //NAVIGATION SETUP
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        composable(route = Screen.HomeScreen.route) {
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
            AddEditProductScreen(
                navController = navController,
                addEditProductViewModel = addEditProductViewModel
            )
        }
    }
}