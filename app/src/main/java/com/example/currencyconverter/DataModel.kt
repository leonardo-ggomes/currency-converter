package com.example.currencyconverter

import com.google.gson.annotations.SerializedName


data class CurrencyResponse(
    @SerializedName("USDBRL") val usdbrl: CurrencyData
)

data class CurrencyData(
    val code: String,
    val codein: String,
    val name: String,
    val high: String,
    val low: String,
    val varBid: String,
    val pctChange: String,
    val bid: String,
    val ask: String,
    val timestamp: String,
    @SerializedName("create_date") val createDate: String
)
