package ma.kader.cosmeticapp.di

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras

fun <VM : ViewModel> viewModelFactory(createViewModel: () -> VM)
        : ViewModelProvider.Factory {

    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return createViewModel() as T
        }
    }
}

fun <VM : ViewModel> viewModelFactoryWithStateHandle(
    createViewModel: (SavedStateHandle) -> VM
): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            val savedStateHandle = extras.createSavedStateHandle()
            return createViewModel(savedStateHandle) as T
        }
    }
}