package com.example.currencyconverter

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("json/last/USD")
    suspend fun getUSD(): CurrencyResponse

}