package com.example.brighterdays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brighterdays.ui.theme.BrighterdaysTheme

class AddstudentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrighterdaysTheme {
               AddstudentScreen()
            }
        }
    }
}

@Composable
fun AddstudentScreen(){
    Column {
        Box(modifier = Modifier.fillMaxWidth()
            .background(Color.Cyan).padding(20.dp)){
           Text(text = "ADD NEW STUDENT",
               fontStyle = FontStyle.Normal,
               fontWeight = FontWeight.Bold,
               fontSize = 25.sp,
               textAlign = TextAlign.Center,
               modifier = Modifier.fillMaxWidth()
               )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddstudentScreenPreview(){
    AddstudentScreen()
}