package com.example.homework2_andtoid3.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework2_andtoid3.R
import com.example.homework2_andtoid3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}