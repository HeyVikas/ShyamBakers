package com.vikas.shyambakers.PresentationLayer

import android.net.Uri
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vikas.shyambakers.DataLayer.Product
import com.vikas.shyambakers.DomainLayer.ServerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var serverRepoRef : ServerRepo
) : ViewModel(){

    var product = mutableStateOf(Product())

    var productName = mutableStateOf("")
    var productDisplay = mutableStateOf<Uri?>(null)
    var productQuantity = mutableIntStateOf(0)
    var productPrice = mutableIntStateOf(0)


    fun sendInventory(){
        viewModelScope.launch {
            serverRepoRef.sendInventory(product.value)
        }
    }

}