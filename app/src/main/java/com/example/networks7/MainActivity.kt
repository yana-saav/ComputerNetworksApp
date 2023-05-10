package com.example.networks7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.networks7.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit = Retrofit.buildService(ApiService::class.java)

        binding.searchButton.setOnClickListener {

            val editText: EditText = binding.namberEditText

            CoroutineScope(Dispatchers.IO).launch {
                val characterNamber = editText.text.toString().toInt()
                val response = retrofit.getData(characterNamber)
                val data = response.body()
                data?.binding(binding)
            }
        }


    }
}