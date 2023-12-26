package com.abbaraees.littlelemon

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navHostController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("littlelemon.prefs", Context.MODE_PRIVATE)
    val firstName = "Muhammad" // sharedPreferences.getString("firstName","")
    val lastName = "Lawal "// sharedPreferences.getString("lastName","")
    val email = "abbaraees@gmail.com" // sharedPreferences.getString("email","")
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header()
        Text(
            "Profile information",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 64.dp, bottom = 32.dp)
        )
        Column(
            Modifier.fillMaxWidth()
        ) {
            Text(text = "First Name")
            if (firstName != null) {
                OutlinedTextField(
                    value = firstName,
                    onValueChange = {},
                    colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White, textColor = Color.Black),
                    enabled = false,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth()
                )
            }
            Text(text = "Last Name")
            if (lastName != null) {
                OutlinedTextField(
                    value = lastName,
                    onValueChange = {},
                    colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White, textColor = Color.Black),
                    enabled = false,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth()
                )
            }
            Text(text = "Email")
            if (email != null) {
                OutlinedTextField(
                    value = email,
                    onValueChange = {},
                    colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White, textColor = Color.Black),
                    enabled = false,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth()
                )
            }

            Button(
                onClick = {
                    sharedPreferences.edit(true) {
                        clear()
                    }
                    navHostController.navigate(Onboarding.route)
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.my_yellow)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp)
            ) {
                Text(text = "Log out", color = Color.Black)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ProfilePreview() {
//    Profile()
}