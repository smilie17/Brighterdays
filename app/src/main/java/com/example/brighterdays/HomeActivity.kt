package com.example.brighterdays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brighterdays.ui.theme.BrighterdaysTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrighterdaysTheme {
                HomeScreen()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Box(){
        Image(painter = painterResource(id = R.drawable.background),
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds
            )
    }
    Column (modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally) {
        TopAppBar(title = { Text(text = "BrighterdaysApp") },
            navigationIcon = { IconButton(onClick = {}){ Icon(imageVector = Icons.Filled.Home,
            contentDescription = "Home") }},
            actions = {
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Filled.Search,
                        contentDescription = "Search") }
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu") }
                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Filled.Person,
                        contentDescription = "Person") }



            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.LightGray,
                navigationIconContentColor = Color.White,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            )
        )
        Row {
            Card (modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.LightGray)
                )
            { Box(modifier = Modifier.height(100.dp)
                                     .padding(25.dp),
                                      contentAlignment = Alignment.Center)
            { Text(text = "Students", color = Color.White) }
            }
            Card (modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.LightGray)
            )
            { Box(modifier = Modifier.height(100.dp)
                .padding(25.dp),
                contentAlignment = Alignment.Center)
            { Text(text = "Teachers", color = Color.White) }
            }
            Card (modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.LightGray)
            )
            { Box(modifier = Modifier.height(100.dp)
                .padding(25.dp),
                contentAlignment = Alignment.Center)
            { Text(text = "Classes", color = Color.White) }
            }
        }
        Row {
            Card (modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.LightGray)
            )
            { Box(modifier = Modifier.height(100.dp)
                .padding(25.dp),
                contentAlignment = Alignment.Center)
            { Text(text = "Exams", color = Color.White) }
            }
            Card (modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.LightGray)
            )
            { Box(modifier = Modifier.height(100.dp)
                .padding(25.dp),
                contentAlignment = Alignment.Center)
            { Text(text = "Fees", color = Color.White) }
            }
            Card (modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(Color.LightGray)
            )
            { Box(modifier = Modifier.height(100.dp)
                .padding(25.dp),
                contentAlignment = Alignment.Center)
            { Text(text = "Notifications", color = Color.White) }
            }
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}