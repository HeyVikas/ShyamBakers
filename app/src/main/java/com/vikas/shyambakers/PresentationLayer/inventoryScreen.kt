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
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

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


                        TextField(value = mainViewModel.productPrice.value.toString(),
                            onValueChange = {
                                mainViewModel.productPrice.value = it.toInt()
                            },
                            label = { Text(text = "Product Price/ unit") }
                        )
                    }
                }
                Row() {

                    Button(onClick = {
                        mainViewModel.product.value = mainViewModel.product.value.copy(
                            productDisplay = mainViewModel.productDisplay.value.toString(),
                            productName = mainViewModel.productName.value,
                            productQuantity = mainViewModel.productQuantity.value,
                            productPrice = mainViewModel.productPrice.value
                        )

                        mainViewModel.sendInventory()

                    }) {
                        Text(text = "Save")
                    }
                }

                //to check the change..
            }
        }

}