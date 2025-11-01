package com.example.praktikum4.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum4.R

@Composable
fun FormFormulirPendaftaran() {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val statusOptions: List<String> = listOf("Janda", "Lajang", "Duda")

    val purpleBackground = Color(0xFFE6D5F5)
    val purpleButton = Color(0xFF7C3AED)
    val purpleHeader = Color(0xFFB794F6)

    Column(
        modifier = modifier
            .background(purpleBackground)
            .padding(dimensionResource(R.dimen.padding_small))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                    textNama = ""
                    textJK = ""
                    textStatus = ""
                    textAlamat = ""
                },
                text = {
                    Column {
                        Text(text = "Nama   : $nama")
                        Text(text = "Gender : $jenis")
                        Text(text = "Status : $status")
                        Text(text = "Alamat : $alamat")
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            textNama = ""
                            textJK = ""
                            textStatus = ""
                            textAlamat = ""
                        }
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        purpleHeader,
                        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Formulir Pendaftaran",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_medium))
                )
            }
            Column (
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState()),
                ) {
                    OutlinedTextField(
                        value = textNama,
                        singleLine = true,
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Nama Lengkap") },
                        onValueChange = {
                            textNama = it
                        }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

                    Column {
                        Text(
                            text = "Jenis Kelamin",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        gender.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .selectable(
                                        selected = textJK == item,
                                        onClick = { textJK = item }
                                    )
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textJK == item,
                                    onClick = {
                                        textJK = item
                                    }
                                )
                                Text(item)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

                    Column {
                        Text(
                            text = "Status Perkawinan",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        statusOptions.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .selectable(
                                        selected = textStatus == item,
                                        onClick = { textStatus = item }
                                    )
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textStatus == item,
                                    onClick = {
                                        textStatus = item
                                    }
                                )
                                Text(item)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                    OutlinedTextField(
                        value = textAlamat,
                        singleLine = true,
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = "Alamat") },
                        onValueChange = {
                            textAlamat = it
                        }
                    )
                }
            }
        }
    }
}