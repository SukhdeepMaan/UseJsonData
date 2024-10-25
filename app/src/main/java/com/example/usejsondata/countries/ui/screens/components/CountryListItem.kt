package com.example.usejsondata.countries.ui.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.usejsondata.countries.domain.model.Country


@Composable
fun CountryListItem(
    country: Country,
    onCountrySelected: (Country) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCountrySelected(country) }
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(
            text = country.name,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "+${country.dialCode}",
            fontWeight = FontWeight.Light
        )
    }
}