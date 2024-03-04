package com.vikas.shyambakers.DomainLayer

import com.google.type.Date
import com.vikas.shyambakers.DataLayer.Bill
import com.vikas.shyambakers.DataLayer.Product
import java.time.Month

interface ServerRepo {

    fun addInventoryProduct(product : Product)
    suspend fun getInventoryProducts() : List<Product>

    fun addSaleBill(bill : Bill, month: Month)

    suspend fun getSaleBills(month: Month, date: Date) : List<Bill>

    suspend fun getTotalSales(month : Month) : Int

    fun addPurchaseBill(bill : Bill, month : Month)
    suspend fun getPurchaseBills(month: Month, date: Date) : List<Bill>

    suspend fun getTotalPurchase(month:Month) : Int
    fun calculateProfit(totalSales : Int, totalPurchase : Int, otherExpense : Int) : Int
    fun maxSoldProduct(month : Month) : Product

}