package com.vikas.shyambakers.PresentationLayer

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.vikas.shyambakers.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetails(nav : NavHostController , mainViewModel: MainViewModel , pickProductImage : ActivityResultLauncher<PickVisualMediaRequest>) {

        Column {
            TopAppBar(title = { Text(text = "Inventory")},
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.LightGray
                )
                )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Box {

                    Column {


                        Box(
                            modifier = Modifier
                                .height(100.dp)
                                .width(100.dp)
                        ) {
                            AsyncImage(
                                model = mainViewModel.productDisplay.value,
                                contentDescription = "Product Image",
                                modifier = Modifier
                                    .width(80.dp)
                                    .height(80.dp)
                            )
                            IconButton(onClick = {
                                pickProductImage.launch(
                                    PickVisualMediaRequest(
                                        ActivityResultContracts.PickVisualMedia.ImageOnly
                                    )
                                )
                            }) {
                                Icon(
                                    imageVector = Icons.Default.AddCircle,
                                    contentDescription = "To add image"
                                )
                            }

                        }



                        TextField(value = mainViewModel.productName.value,
                            onValueChange = {
                                mainViewModel.productName.value = it
                            },
                            label = { Text(text = "Product Name") }
                        )

                        TextField(value = mainViewModel.productQuantity.value.toString(),
                            onValueChange = {
                                mainViewModel.productQuantity.value = it.toInt()
                            },
                            label = { Text(text = "Product Quantity") }
                        )


                        TextField(value = mainViewModel.productPurchasePrice.value.toString(),
                            onValueChange = {
                                mainViewModel.productPurchasePrice.value = it.toInt()
                            },
                            label = { Text(text = "Product Purchase Price/ unit") }
                        )

                        TextField(value = mainViewModel.productSalePrice.value.toString(),
                            onValueChange = {
                                mainViewModel.productSalePrice.value = it.toInt()
                            },
                            label = { Text(text = "Product Sale Price/ unit") }
                        )
                    }
                }
                Row() {

                    Button(onClick = {
                        mainViewModel.addInventoryProduct()

                        mainViewModel.productDisplay.value = R.drawable.product_display.toString().toUri()
                        mainViewModel.productName.value = ""
                        mainViewModel.productPurchasePrice.value = 0
                        mainViewModel.productSalePrice.value = 0
                        mainViewModel.productQuantity.value = 0

                    }) {
                        Text(text = "Save")
                    }
                }

                //to check the change..
            }
        }

}