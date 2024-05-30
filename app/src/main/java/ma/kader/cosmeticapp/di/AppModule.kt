package ma.kader.cosmeticapp.di

import android.content.Context
import androidx.room.Room
import ma.kader.cosmeticapp.data.data_source.ProductDatabase
import ma.kader.cosmeticapp.data.repository.ProductRepositoryImpl
import ma.kader.cosmeticapp.domain.repository.ProductRepository

class AppModuleImpl(private val appContext: Context) : AppModule {

    override val db: ProductDatabase by lazy {
        Room.databaseBuilder(appContext, ProductDatabase::class.java, ProductDatabase.DATABASE_NAME)
            .build()
    }

    override val productRepository: ProductRepository by lazy {
        ProductRepositoryImpl(db.dao)
    }
}

interface AppModule {
    val db: ProductDatabase
    val productRepository: ProductRepository
}