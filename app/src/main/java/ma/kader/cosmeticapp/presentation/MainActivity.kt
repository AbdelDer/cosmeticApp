package ma.kader.cosmeticapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ma.kader.cosmeticapp.CosmeticApplication
import ma.kader.cosmeticapp.di.viewModelFactory
import ma.kader.cosmeticapp.di.viewModelFactoryWithStateHandle
import ma.kader.cosmeticapp.presentation.add_edit_product.AddEditProductViewModel
import ma.kader.cosmeticapp.presentation.products.ProductsViewModel
import ma.kader.cosmeticapp.ui.navigation.AppNavHost
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

                val addEditProductViewModel = viewModel<AddEditProductViewModel>(
                    factory = viewModelFactoryWithStateHandle { savedStateHandle ->
                        AddEditProductViewModel(
                            productRepository = CosmeticApplication.appModule.productRepository,
                            savedStateHandle = savedStateHandle
                        )
                    }
                )

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost(
                        productsViewModel = productsViewModel,
                        addEditProductViewModel = addEditProductViewModel
                    )
                }
            }
        }
    }
}