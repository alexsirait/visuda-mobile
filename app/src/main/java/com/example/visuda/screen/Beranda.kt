package com.example.visuda.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.visuda.R
import com.example.visuda.navigation.Routes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun BerandaPage(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = remember { context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE) }
    val coroutineScope = rememberCoroutineScope()
    var username = remember { sharedPreferences.getString("username", "User") }
    var nik = remember { sharedPreferences.getString("nik", "User") }
    var rt = remember { sharedPreferences.getString("rt", "User") }
    var rw = remember { sharedPreferences.getString("rw", "User") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bgberanda),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(270.dp),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 170.dp)
                ) {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                        ) {
                            Text(
                                text = "Nama : $username",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Start
                                ), modifier = Modifier.padding(4.dp)
                            )
                            Text(
                                text = "NIK : $nik",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Start
                                ), modifier = Modifier.padding(4.dp)
                            )
                            Text(
                                text = "RW : $rw",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Start
                                ), modifier = Modifier.padding(4.dp)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "RT : $rt",
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        textAlign = TextAlign.Start
                                    ), modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 8.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.bendera),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            Divider(
                                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                            )
                            Row(
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_card),
                                    contentDescription = "Card",
                                    tint = Color.Black
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(text = "11***********9870", color = Color.Black)
                            }

                        }
                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = (-40).dp, x = 120.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.White, CircleShape)
                        )
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 50.dp)
            ) {
                Button(
                    onClick = { navController.navigate(Routes.DaftarSurat.route) },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .height(62.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A2083))
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.Description,
                            contentDescription = "Pengajuan Surat",
                            tint = Color.White
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(text = "PENGAJUAN SURAT", color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { navController.navigate(Routes.DataKeluarga.route) },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .height(62.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A2083))
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Pendataan Warga",
                            tint = Color.White
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(text = "PENDATAAN WARGA", color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyRow(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
                ) {
                    items(3) {
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier
                                .width(165.dp)
                                .height(160.dp)
                                .padding(8.dp, top = 10.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.gbberita),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxWidth()
                                )
                                Text(
                                    text = "Laporan Keuangan Bul..",
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        textAlign = TextAlign.Center
                                    ), modifier = Modifier.padding(4.dp)
                                )
                                Text(
                                    text = "20 Maret 2024",
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 10.sp,
                                        textAlign = TextAlign.Start,
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic
                                    ), modifier = Modifier.padding(start = 4.dp, top = 4.dp)
                                )

                                Spacer(modifier = Modifier.weight(1f))

                                Text(
                                    text = "Details >",
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 10.sp,
                                        textAlign = TextAlign.End,
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic
                                    ), modifier = Modifier
                                        .padding(end = 4.dp, bottom = 4.dp)
                                        .align(Alignment.End)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun preview() {
    BerandaPage(navController = rememberNavController())
}