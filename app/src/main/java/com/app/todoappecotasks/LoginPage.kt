@file:Suppress("DEPRECATION")

package com.app.todoappecotasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.compose.material3.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9F5EA))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = R.mipmap.ecotasks),
            contentDescription = "Logo Eco Tasks",
            modifier = Modifier.size(300.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Não perca tempo, entre já!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF14532D),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(50),
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                Color.Black
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(50),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                Color.Black
            )

        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    val dao = MainApplication.todoDatabase.userDao()
                    val usuario = dao.authenticate(email, senha)
                    if (usuario != null) {
                        withContext(Dispatchers.Main) {
                            navController.navigate("welcome/${email}")
                        }
                    } else {
                        dao.addUser(User(email = email, senha = senha))
                        withContext(Dispatchers.Main) {
                            navController.navigate("welcome/${email}")
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF14532D),
                contentColor = Color.White
            )
        ) {
            Text("Entrar", fontSize = 18.sp)
        }
    }
}