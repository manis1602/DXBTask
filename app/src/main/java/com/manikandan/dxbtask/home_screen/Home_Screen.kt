package com.manikandan.dxbtask.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manikandan.dxbtask.R
import com.manikandan.dxbtask.home_screen.util.Screen
import com.manikandan.dxbtask.home_screen.util.SubNavigationDetail
import com.manikandan.dxbtask.ui.theme.DarkBlue
import com.manikandan.dxbtask.ui.theme.LightBlue
import java.util.*

@Composable
fun HomeScreen() {
    HomeScreenDesign()
}

@Composable
fun HomeScreenDesign() {
    val subNavigationDetails = SubNavigationDetail.getAllDetails()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                backgroundColor = LightBlue,
                contentColor = Color.White,
                shape = CircleShape,
            ) {
                Column(modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.noun_add_receipt),
                        contentDescription = "add_receipt_icon"
                    )
                    Text(text = "New Order", fontSize = 10.sp)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(80.dp)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                cutoutShape = CircleShape,
                backgroundColor = Color.White,
                elevation = 10.dp
            ) {
                BottomBar()
            }
        },
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .clip(RoundedCornerShape(0.dp, 0.dp, 40.dp, 40.dp)),
                    painter = painterResource(id = R.drawable.vector_background),
                    contentDescription = "home_background",
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .weight(1f)
                            .size(60.dp),
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo",
                        alignment = Alignment.CenterStart
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.hamburger_menu),
                            contentDescription = "hamburger_menu",
                            tint = Color.White
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(0.55f)
                        .align(Alignment.BottomCenter)
                ) {
                    subNavigationDetails.forEach {
                        SingleHomeSection(
                            title = it.title,
                            icon = it.leadingIcon,
                            isDarkBackground = it.isDarkBackground
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    )
}

@Composable
fun SingleHomeSection(
    title: String,
    icon: Int,
    isDarkBackground: Boolean
) {
    Card(
        modifier = Modifier.heightIn(min = 70.dp),
        backgroundColor = if (isDarkBackground) DarkBlue else LightBlue,
        contentColor = if (isDarkBackground) LightBlue else DarkBlue,
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "noun_order_filled"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title.uppercase(Locale.getDefault()),
                fontSize = MaterialTheme.typography.body1.fontSize,
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(
                modifier = Modifier
                    .background(
                        color = if (isDarkBackground) LightBlue else DarkBlue,
                        shape = RoundedCornerShape(100),
                    )
                    .then(Modifier.size(30.dp)),
                onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "right_arrow",
                    tint = if (isDarkBackground) DarkBlue else LightBlue
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun BottomBar() {
    val screens = listOf(
        Screen.Home,
        Screen.Orders,
        Screen.Notifications,
        Screen.MyAccount
    )
    var selectedScreen by remember {
        mutableStateOf(screens[0])
    }
    BottomNavigation(backgroundColor = Color.White) {
        screens.forEachIndexed { index, screen ->
            if (index == 2)
                Spacer(modifier = Modifier.weight(0.7f))
            BottomNavigationItem(
                label = {
                    Text(
                        text = screen.title,
                        fontSize = 10.sp
                    )
                },
                selected = screen == selectedScreen,
                onClick = { selectedScreen = screen },
                icon = {
                    Icon(
                        painter = painterResource(id = if (selectedScreen == screen) screen.selectedIcon else screen.icon),
                        contentDescription = screen.title,
                        tint = if (selectedScreen == screen) DarkBlue else LightBlue
                    )
                })
        }
    }
}