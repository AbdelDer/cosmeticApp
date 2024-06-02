package ma.kader.cosmeticapp.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import ma.kader.cosmeticapp.domain.model.Product

@Dao
interface ProductDao {
    @Upsert
    suspend fun upsertProduct(product: Product)
    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("SELECT * FROM product")
    fun getProducts(): Flow<List<Product>>

    @Query("SELECT * FROM product WHERE id = :id")
    suspend fun getProductById(id: Int): Product?
}