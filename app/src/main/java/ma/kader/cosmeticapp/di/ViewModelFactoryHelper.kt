package ma.kader.cosmeticapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun <VM : ViewModel> viewModelFactory(createViewModel: () -> VM)
        : ViewModelProvider.Factory {

    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return createViewModel() as T
        }
    }
}