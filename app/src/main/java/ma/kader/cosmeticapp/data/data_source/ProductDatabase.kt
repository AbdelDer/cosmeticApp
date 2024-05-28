package ma.kader.cosmeticapp.data.data_source

import androidx.room.Database
import ma.kader.cosmeticapp.domain.model.Product

@Database(
    entities = [Product::class],
    version = 1
)
abstract class ProductDatabase {

    abstract val dao: ProductDao
    companion object {
        const val DATABASE_NAME = "product_db"
    }
}