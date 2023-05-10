package com.example.networks7

import com.example.networks7.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface Data {

    suspend fun binding(binding: ActivityMainBinding)

    data class DataCharacters(
        private val characters: String,
        private val name: String,
        private val gender:  String,
        private val culture: String
    ) : Data {
        override suspend fun binding(binding: ActivityMainBinding) = withContext(Dispatchers.Main) {
            binding.cultureTextView.text = culture
            binding.nameTextView.text = name
            binding.genderTextView.text = gender
        }
    }
}

