package com.vikas.shyambakers.DomainLayer

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.type.Date
import com.vikas.shyambakers.DataLayer.Bill
import com.vikas.shyambakers.DataLayer.Product
import java.time.Month

class ServerRepoImpl : ServerRepo {

    val db = Firebase.firestore

    override fun addInventoryProduct(product: Product) {

        db.collection("Inventory")
            .document()
            .set(product)

    }

    override suspend fun getInventoryProducts(): List<Product> {
        TODO("Not yet implemented")
    }

    override fun addSaleBill(bill: Bill, month: Month) {
        TODO("Not yet implemented")
    }

    override suspend fun getSaleBills(month: Month, date: Date): List<Bill> {
        TODO("Not yet implemented")
    }

    override suspend fun getTotalSales(month: Month): Int {
        TODO("Not yet implemented")
    }

    override fun addPurchaseBill(bill: Bill, month: Month) {
        TODO("Not yet implemented")
    }

    override suspend fun getPurchaseBills(month: Month, date: Date): List<Bill> {
        TODO("Not yet implemented")
    }

    override suspend fun getTotalPurchase(month: Month): Int {
        TODO("Not yet implemented")
    }

    override fun calculateProfit(totalSales: Int, totalPurchase: Int, otherExpense: Int): Int {
        TODO("Not yet implemented")
    }

    override fun maxSoldProduct(month: Month): Product {
        TODO("Not yet implemented")
    }


}