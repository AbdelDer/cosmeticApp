package ma.kader.cosmeticapp.presentation.util

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object AddEditProductScreen: Screen("add_edit_product_screen")
}
