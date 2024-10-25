package com.example.usejsondata.countries.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.usejsondata.countries.ui.screens.components.CountryListItem
import com.example.usejsondata.countries.ui.viewmodel.CountryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPickerScreen() {
    val countryViewModel: CountryViewModel = hiltViewModel()
    val countries by countryViewModel.countries.collectAsState(initial = emptyList())
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("Select Country") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Country Picker") }
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                // Display selected country text at the top
                Text(
                    text = selectedCountry,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.align(Alignment.TopCenter)
                )

                // Button to open bottom sheet
                Button(
                    onClick = { showBottomSheet = true },
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text("Choose Country")
                }
            }
        }
    )

    // Show Modal Bottom Sheet if `showBottomSheet` is true
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false }
        ) {
            LazyColumn {
                items(countries) { country ->
                    CountryListItem(
                        country = country,
                        onCountrySelected = {
                            selectedCountry = it.name
                            showBottomSheet = false
                        }
                    )
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPickerScreen2() {
    val countryViewModel: CountryViewModel = hiltViewModel()
    val countries by countryViewModel.countries.collectAsState()
    var selectedCountry by remember { mutableStateOf("Select Country") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Country Picker") }
            )
        },
        content = { padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                item {
                    Text(
                        text = selectedCountry,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                items(countries) { country ->
                    CountryListItem(
                        country = country,
                        onCountrySelected = { selectedCountry = it.name }
                    )
                }
            }
        }
    )
}
