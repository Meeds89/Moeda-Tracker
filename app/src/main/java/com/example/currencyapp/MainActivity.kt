package com.example.currencyapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyapp.data.adapter.CoinAdapter
import com.example.currencyapp.data.retrofit.RetrofitInstance
import com.example.currencyapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        loadCurrency()
    }

    private fun loadCurrency() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val currency = RetrofitInstance.api.getAll()
                runOnUiThread {
                    binding.recyclerView.adapter = CoinAdapter(currency)
                }
            } catch (e: Exception) {
                Log.e("erro", "${e.cause}")
            }
        }
    }
}