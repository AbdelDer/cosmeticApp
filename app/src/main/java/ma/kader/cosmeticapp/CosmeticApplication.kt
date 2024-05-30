package ma.kader.cosmeticapp

import android.app.Application
import ma.kader.cosmeticapp.di.AppModule
import ma.kader.cosmeticapp.di.AppModuleImpl

class CosmeticApplication : Application() {
    companion object {
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }
}