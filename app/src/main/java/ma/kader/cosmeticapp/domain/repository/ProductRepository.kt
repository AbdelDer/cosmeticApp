package ma.kader.cosmeticapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ma.kader.cosmeticapp.domain.model.Product

interface ProductRepository {
        suspend fun insertProduct(product: Product)

        suspend fun deleteProduct(product: Product)

        fun getProducts(): Flow<List<Product>>

        suspend fun getProductById(id: Int): Product?
}