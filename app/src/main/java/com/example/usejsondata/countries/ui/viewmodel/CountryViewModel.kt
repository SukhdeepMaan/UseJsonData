package com.example.usejsondata.countries.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usejsondata.countries.domain.model.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    @ApplicationContext private val
    context: Context) : ViewModel() {
    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries

    private fun loadCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            val inputStream = context.assets.open("country.json")
            val jsonText = inputStream.bufferedReader().use { it.readText() }
            _countries.value = Json.decodeFromString(jsonText)
        }
    }
}