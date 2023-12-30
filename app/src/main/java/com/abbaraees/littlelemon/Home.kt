package com.abbaraees.littlelemon

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navHostController: NavHostController, viewModel: HomeScreenViewModel) {
    val searchPhrase = rememberSaveable {
        mutableStateOf("")
    }
    val menuItems: List<MenuItemRoom> = viewModel.menuItems
    


    Column(
        Modifier
            .fillMaxSize()
    ) {
        // Header
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth(.75f)
                    .height(50.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "User Profile",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clickable {
                        navHostController.navigate(Profile.route)
                    }

            )
        }

        // Hero
        Column(
            Modifier
                .background(colorResource(id = R.color.my_green))
                .fillMaxWidth()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.name),
                    fontSize = 32.sp,
                    color = colorResource(id = R.color.my_yellow)
                )
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        Modifier
                            .height(130.dp)
                            .fillMaxWidth(.7f)

                    ) {
                        Text(
                            text = stringResource(R.string.location),
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Text(
                            text = stringResource(R.string.description),
                            color = Color.White,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.hero_image),
                        contentDescription = "Hero Image",
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .height(100.dp)
                    )
                }
                OutlinedTextField(
                    value = searchPhrase.value,
                    onValueChange = {
                        searchPhrase.value = it
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White
                    ),
                    placeholder = {
                        Text("Enter search phrase")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )
            }
        }


        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Filters
            Text(
                text = "ORDER FOR DELIVERY!",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffedefee),
                        contentColor = Color(0xff333333)
                    )
                ) {
                    Text(text = "Starters", fontSize = 10.sp)
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffedefee),
                        contentColor = Color(0xff333333)
                    )
                ) {
                    Text(text = "Mains", fontSize = 10.sp)
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffedefee),
                        contentColor = Color(0xff333333)
                    )
                ) {
                    Text(text = "Desserts", fontSize = 10.sp)
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffedefee),
                        contentColor = Color(0xff333333)
                    )
                ) {
                    Text(text = "Drinks", fontSize = 10.sp)
                }
            }

            Divider(thickness = 1.dp, color = Color(0xffaaaaaa))
            MenuItems(menuItems = menuItems)

        }


    }
}

@Composable
fun MenuItems(menuItems: List<MenuItemRoom>) {
    LazyColumn(
        Modifier.fillMaxWidth()
    ) {
        items(menuItems) {menuItem ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    Modifier.fillMaxWidth(.7f),
                ) {
                    Text(
                        text = menuItem.title,
                        fontSize=14.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = menuItem.description,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "$${menuItem.price}",
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
            }
            Divider(thickness = 1.dp, color = Color(0xffaaaaaa))
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//    Home(rememberNavController(), db)
//}