package kz.technodom.technodomsample

import androidx.annotation.DrawableRes

data class AccessoriesItem(
    @DrawableRes
    val imageRes: Int,
    val title: String,
    val price: String,
    val oldPrice: String? = null
)