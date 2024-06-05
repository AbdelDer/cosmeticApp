package ma.kader.cosmeticapp.presentation.util

sealed class Screen(val route: String) {
    data object HomeScreen: Screen("home_screen")
    data object AddEditProductScreen: Screen("add_edit_product_screen")
}
