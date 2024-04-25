package com.soyaeeb.musicpartner.navigation.navigationdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerHeader(
    userName: String = "Soyaeeb Monir",
    userPhoto: ImageVector = Icons.Default.Person,
    networkStatus: String = "Online"
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            painter = painterResource(id = com.soyaeeb.assets.R.drawable.ic_person),
            contentDescription = "User Image",
            contentScale = ContentScale.Crop,
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = userName,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = networkStatus,
                fontSize = 12.sp
            )
        }
    }
}