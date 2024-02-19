package com.vikas.shyambakers.DomainLayer

import com.vikas.shyambakers.DataLayer.Product

interface ServerRepo {

    suspend fun sendInventory(product: Product)
}