package com.example.graphql.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graphql.domain.SimpleCountry


@Composable
fun CountryScreen(
    modifier: Modifier = Modifier,
    state: CountriesViewModel.CountriesState,
    onSelectCountry: (code: String) -> Unit,
    onDismissDialog: () -> Unit,
) {
    Box(modifier = modifier.fillMaxSize().safeContentPadding()) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = modifier.align(Alignment.Center)
            )
        }else{
            LazyColumn(modifier = modifier.fillMaxSize()) {
                items(state.countries){
                    country: SimpleCountry ->
                    CountryItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelectCountry(country.code) }
                            .padding(10.dp)
                        ,simpleCountry = country)
                }
            }
            if (state.selectedCountry != null) {
                CountryDialog(
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)).background(Color.White).padding(16.dp)
                    ,country = state.selectedCountry, onDismiss = onDismissDialog)
            }
        }
    }
}


@Composable
fun CountryItem(modifier: Modifier = Modifier,simpleCountry: SimpleCountry) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = simpleCountry.emoji, fontSize = 30.sp)
        Spacer(modifier = Modifier.width(30.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = simpleCountry.name, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = simpleCountry.code, fontSize = 16.sp)

        }
    }
}