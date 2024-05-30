package ma.kader.cosmeticapp.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import ma.kader.cosmeticapp.domain.model.Product

@Database(
    entities = [Product::class],
    version = 1
)
abstract class ProductDatabase: RoomDatabase() {

    abstract val dao: ProductDao
    companion object {
        const val DATABASE_NAME = "product_db"
    }
}