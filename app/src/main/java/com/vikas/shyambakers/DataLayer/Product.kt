package com.vikas.shyambakers.DataLayer

data class Product(
    var productId : String = "",
    var productName : String = "",
    var productDisplay : String = "",
    var productQuantity : Int = 0,
    var productVariant : String = "",
    var productPurchasePrice : Int = 0,
    var productSalePrice : Int = 0,
    var productIsChanged : Boolean = false
)
