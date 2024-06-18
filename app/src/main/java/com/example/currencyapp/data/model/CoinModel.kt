package com.example.currencyapp.data.model

data class CoinModel(
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
    val createDate: String
)

data class CoinNames(
    val USDBRL: CoinModel,
    val EURBRL: CoinModel,
    val BTCBRL: CoinModel
)