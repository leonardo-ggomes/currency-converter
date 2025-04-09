package com.example.currencyconverter

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencyconverter.ui.theme.CurrencyConverterTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {

    var dolar by remember { mutableStateOf(5f) }
    var real by remember { mutableStateOf(0f) }
    var cotacao by remember { mutableStateOf<CurrencyData?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var bid by remember { mutableFloatStateOf(0f) }

    val scope = rememberCoroutineScope()

    LaunchedEffect(true) {
        scope.launch {
            try{
                cotacao = ApiRepository().getCurrencyDataFormFromAPI()
                cotacao?.let { bid = it.bid.toFloat() }
                errorMessage = null
            }
            catch (e: Exception){
                errorMessage = "Falhou"
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        errorMessage?.let {
            Toast.makeText(LocalContext.current,it, Toast.LENGTH_SHORT).show()
        }


        OutlinedTextField(
            onValueChange = {
                dolar = it.toFloat()
            },
            value = dolar.toString(),
            maxLines = 1,
            label = {
                Text(text = "Dólar")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            ),
            leadingIcon = {
                Image(painter = painterResource(id = R.drawable.eua), contentDescription = "USD",  modifier = Modifier.size(24.dp))
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.DarkGray,    // Cor da borda quando está em foco
                unfocusedBorderColor = Color.Gray,  // Cor da borda quando não está em foco
                focusedLabelColor = Color.DarkGray,     // Cor do texto do label quando está em foco
                unfocusedLabelColor = Color.Gray    // Cor do texto do label quando não está em foco
            )

        )
        Spacer(modifier = Modifier.size(20.dp))
        OutlinedTextField(
            onValueChange = {
                real = it.toFloat()
            },
            value = (bid * dolar).toString(),
            maxLines = 1,
            label = {
                Text(text = "Real")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            ),
            leadingIcon = {
                Image(painter = painterResource(id = R.drawable.brasil), contentDescription = "BRL",  modifier = Modifier.size(24.dp))
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.DarkGray,    // Cor da borda quando está em foco
                unfocusedBorderColor = Color.Gray,  // Cor da borda quando não está em foco
                focusedLabelColor = Color.DarkGray,     // Cor do texto do label quando está em foco
                unfocusedLabelColor = Color.Gray,    // Cor do texto do label quando não está em foco
                disabledBorderColor = Color.Gray,
                disabledTextColor = Color.DarkGray
            ),
            enabled = false
        )



    }
}


@Preview(showBackground = true)
@Composable
fun CurrencyPreview() {
    CurrencyConverterTheme {
        Main()
    }
}
