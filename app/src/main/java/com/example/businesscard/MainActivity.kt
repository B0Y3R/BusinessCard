package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box (Modifier.background(Color.LightGray)) {
                        Column(
                            verticalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxSize(1f)
                        ) {
                            Column( verticalArrangement = Arrangement.Bottom , horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth(1f).fillMaxHeight(.5f)) {
                                CardImage()
                                Text("James Boyer", fontSize = 40.sp)
                                Text("Android Developer", color = Color.Black, fontWeight = FontWeight.Bold)
                            }
                            Column( horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxWidth(1f).fillMaxHeight(.5f)) {
                                ContactRow(icon = Icons.Rounded.Phone, infoText = "+1 283-293-0400" )
                                ContactRow(icon = Icons.Rounded.AccountCircle, infoText = "@B0Y3R" )
                                ContactRow(icon = Icons.Rounded.MailOutline, infoText = "b0y3r@h0tm41l.c0m" )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CardImage() {
    val image = painterResource(id = R.drawable.android_logo)
    Box(
        Modifier
            .size(100.dp)
            .background(Color.Black)
    ) {
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.size(150.dp) )
    }
}

@Composable
fun ContactRow(icon: ImageVector, infoText: String ) {
    Row( verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth(.5f).padding(bottom = 8.dp)) {
        Icon(icon, contentDescription = null, modifier = Modifier.padding(end = 16.dp) )
        Text(text = infoText, fontSize = 14.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Left)
    }
}
