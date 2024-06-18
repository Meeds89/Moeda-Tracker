package com.example.currencyapp.data.retrofit

import com.example.currencyapp.data.model.CoinModel
import com.example.currencyapp.data.model.CoinNames
import retrofit2.http.GET

interface CoinsApi {
    @GET("last/USD-BRL,EUR-BRL,BTC-BRL")
    suspend fun getAll(): CoinNames
}