package ma.kader.cosmeticapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    val title: String,
    val description: String,
    val createdAt: Long,
    @PrimaryKey val id: Int? = null
)
