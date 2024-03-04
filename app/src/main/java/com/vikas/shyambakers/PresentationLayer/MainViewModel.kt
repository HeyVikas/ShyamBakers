package com.vikas.shyambakers.PresentationLayer

import android.net.Uri
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vikas.shyambakers.DataLayer.Product
import com.vikas.shyambakers.DomainLayer.ServerRepo
import com.vikas.shyambakers.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var serverRepoRef : ServerRepo
) : ViewModel(){

    var product = mutableStateOf(Product())

    var productName = mutableStateOf("")
    var productDisplay = mutableStateOf<Uri?>(R.drawable.product_display.toString().toUri())
    var productQuantity = mutableIntStateOf(0)
    var productPurchasePrice = mutableIntStateOf(0)
    var productSalePrice = mutableIntStateOf(0)

    fun addInventoryProduct(){
        product.value = product.value.copy(
            productDisplay = productDisplay.value.toString(),
            productName = productName.value,
            productQuantity = productQuantity.value,
            productPurchasePrice = productPurchasePrice.value,
            productSalePrice = productSalePrice.value
        )
        viewModelScope.launch {
            serverRepoRef.addInventoryProduct(product.value)
        }
    }

}