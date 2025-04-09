package com.example.currencyconverter

class ApiRepository {

    private val apiService = RetrofitInstance.retrofit.create(ApiService::class.java)

    suspend fun getCurrencyDataFormFromAPI(): CurrencyData{
        val response = apiService.getUSD()
        return response.usdbrl
    }

}