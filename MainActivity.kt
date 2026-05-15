package com.example.hastashilpa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HastaShilpaApp()
        }
    }
}

@Composable
fun HastaShilpaApp() {

    val products = listOf(
        "Bamboo Laptop Stand",
        "Modern Lamp Shade",
        "Eco Storage Basket",
        "Bamboo Coffee Table",
        "Plant Holder"
    )

    var materialCost by remember { mutableStateOf("") }
    var hoursWorked by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5DC))
            .padding(16.dp)
    ) {

        item {

            Text(
                text = "Hasta-Shilpa",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Traditional Craft Meets Modern Design"
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Trending Designs",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        items(products) { item ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = item,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Modern bamboo product for urban markets"
                    )
                }
            }
        }

        item {

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Price Calculator",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = materialCost,
                onValueChange = { materialCost = it },
                label = { Text("Material Cost") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = hoursWorked,
                onValueChange = { hoursWorked = it },
                label = { Text("Hours Worked") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {

                    val material = materialCost.toIntOrNull() ?: 0
                    val hours = hoursWorked.toIntOrNull() ?: 0

                    val finalPrice = material + (hours * 100)

                    result = "Suggested Price: ₹$finalPrice"
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Calculate Price")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = result,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20)
            )
        }
    }
}
