package com.vikas.shyambakers.DataLayer

import java.sql.Timestamp
import java.util.Calendar

data class Bill(
    var billId : String = "",
    var products : List<Product>,
    var totalAmount : Int = 0,
    var date : Timestamp
)
