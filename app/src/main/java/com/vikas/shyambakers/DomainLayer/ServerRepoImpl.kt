package com.vikas.shyambakers.DomainLayer

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vikas.shyambakers.DataLayer.Product

class ServerRepoImpl : ServerRepo {

    val db = Firebase.firestore

    override suspend fun sendInventory(product: Product) {

        db.collection("Inventory")
            .document()
            .set(product)
            .addOnSuccessListener {
                Log.e("TAG","Bhej diya data")
            }
    }


}