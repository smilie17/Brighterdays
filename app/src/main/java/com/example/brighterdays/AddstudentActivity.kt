package com.example.brighterdays

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
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
    val imageUri = rememberSaveable() { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent())
    {uri: Uri? ->
        uri?.let {imageUri.value=it} }
    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var description by  remember { mutableStateOf("") }
    Column (modifier = Modifier.fillMaxSize()
        .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
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
        Card (shape = CircleShape,
                      modifier = Modifier.padding(10.dp).size(200.dp)
            ) {
            AsyncImage(
                model = imageUri.value?:R.drawable.ic_person,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp).clickable {launcher.launch("image/")}
            )
        }
        Text(text = "Upload your Picture")

        OutlinedTextField(
            value = name,
            onValueChange = {newName->name=newName},
            label = { Text(text = "Enter Name") },
            placeholder = { Text(text = "Please enter name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = gender,
            onValueChange = {newGender->gender=newGender},
            label = { Text(text = "Enter Gender") },
            placeholder = { Text(text = "Please enter your gender") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = course,
            onValueChange = {newCourse->course=newCourse},
            label = { Text(text = "Enter Course") },
            placeholder = { Text(text = "Please enter your course") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description,
            onValueChange = {newDescription->description=newDescription},
            label = { Text(text = "Enter Description") },
            placeholder = { Text(text = "Please enter your description") },
            modifier = Modifier.fillMaxWidth().height(150.dp),
            singleLine = false
        )
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,){
            Button(onClick = {}, modifier = Modifier, colors = ButtonDefaults.buttonColors(Color.Black)) { Text(text = "Dashboard") }
            Button(onClick = {}, modifier = Modifier, colors = ButtonDefaults.buttonColors(Color.Green)) { Text(text = "Save") }
        }

    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddstudentScreenPreview(){
    AddstudentScreen()
}