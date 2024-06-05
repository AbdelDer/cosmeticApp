package ma.kader.cosmeticapp.data.repository

import kotlinx.coroutines.flow.Flow
import ma.kader.cosmeticapp.data.data_source.ProductDao
import ma.kader.cosmeticapp.domain.model.Product
import ma.kader.cosmeticapp.domain.repository.ProductRepository

class ProductRepositoryImpl(val productDao: ProductDao): ProductRepository {
    override suspend fun insertProduct(product: Product) {
        productDao.upsertProduct(product)
    }

    override suspend fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }

    override fun getProducts(): Flow<List<Product>> {
        return productDao.getProducts()
    }

    override suspend fun getProductById(id: Int): Product? {
        return productDao.getProductById(id)
    }
}