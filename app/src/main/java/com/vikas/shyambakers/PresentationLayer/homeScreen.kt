package com.vikas.shyambakers.PresentationLayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.errorprone.annotations.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(mainViewModel: MainViewModel, nav: NavHostController) {


    Column {


        TopAppBar(
            title = { Text(text = "DashBoard") },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.LightGray
            )
        )
    }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {


            HomeCard("AddProduct")
            HomeCard("Products List")
            HomeCard("Sale Product")
            HomeCard("Purchase Product")
            HomeCard("Status")


        }

}


@Composable
fun HomeCard(text: String/*, screen : Screens*/) {

    Card()
    {
        Row(
            verticalAlignment = Alignment.CenterVertically
            // modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = text)
        }

       // Spacer(modifier = Modifier.height(20.dp))

    }
}