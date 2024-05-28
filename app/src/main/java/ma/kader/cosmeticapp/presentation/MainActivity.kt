package ma.kader.cosmeticapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ma.kader.cosmeticapp.presentation.add_edit_product.AddEditProductScreen
import ma.kader.cosmeticapp.presentation.home.HomeScreen
import ma.kader.cosmeticapp.presentation.util.Screen
import ma.kader.cosmeticapp.ui.theme.CosmeticAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CosmeticAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //NAVIGATION SETUP
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(navController = navController)
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