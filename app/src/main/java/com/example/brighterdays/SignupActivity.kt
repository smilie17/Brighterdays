package com.example.brighterdays

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.brighterdays.ui.theme.BrighterdaysTheme

class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrighterdaysTheme {
                SignupScreen()

            }
        }
    }
}

@Composable
fun SignupScreen(){
    var fullname by remember { mutableStateOf("") }
    var emailaddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val imageUri = rememberSaveable() { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()){uri: Uri? -> uri.let { imageUri.value=it } }
    Column (modifier = Modifier.padding(25.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Card (shape = CircleShape){ AsyncImage(
            model = imageUri.value?:R.drawable.ic_person,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier.size(200.dp).clickable { launcher.launch("image/") }
        ) }
        Text(text = "Sign Up",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
                               .padding(20.dp)
            )
        Text(text = "Sign up into your account")
        Spacer(modifier = Modifier.padding(20.dp))

       OutlinedTextField(
           value = fullname,
           onValueChange = {newFullname->fullname=newFullname},
           label = { Text(text = "Enter fullname") },
           placeholder = { Text(text = "Please enter your full name") },
           modifier = Modifier.fillMaxWidth(),
       )
        Spacer(modifier = Modifier.padding(5.dp))
        OutlinedTextField(
            value = emailaddress,
            onValueChange = {newEmailadrress->emailaddress=newEmailadrress},
            label = { Text(text = "Enter your email address") },
            placeholder = { Text(text = "Please enter your email address") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(5.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {newPassword->password=newPassword},
            label = { Text(text = "Enter your password") },
            placeholder = { Text(text = "Please enter your password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(5.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {newPassword->password=newPassword},
            label = { Text(text = "Confirm your password") },
            placeholder = { Text(text = "Please enter your password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Black)) { Text(text = "Sign Up") }
        Text(text = buildAnnotatedString { append("Already have an account...Sign In Here!!") }, color = Color.Blue )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignupScreenPreview(){
    SignupScreen()
}