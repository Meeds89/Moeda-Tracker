package com.example.currencyapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.R
import com.example.currencyapp.data.model.CoinModel
import com.example.currencyapp.data.model.CoinNames

class CoinAdapter(private val coin: CoinNames) : RecyclerView.Adapter<CoinAdapter.CoinVH>() {

    private val coinsList: List<CoinModel> = listOfNotNull(coin.USDBRL, coin.EURBRL, coin.BTCBRL)

    inner class CoinVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvCoinName)
        val rate: TextView = itemView.findViewById(R.id.tvCoinRate)
        val high: TextView = itemView.findViewById(R.id.tvCoinHighRate)
        val low: TextView = itemView.findViewById(R.id.tvCoinLowRate)
        val rateChange: TextView = itemView.findViewById(R.id.tvCoinChange)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin_data, parent, false)
        return CoinVH(view)
    }

    override fun getItemCount() = coinsList.size

    override fun onBindViewHolder(holder: CoinVH, position: Int) {
        val coins = coinsList[position]

        holder.name.text = coins.name
        holder.rate.text = coins.bid
        holder.high.text = coins.high
        holder.low.text = coins.low
        holder.rateChange.text = coins.pctChange
    }
}