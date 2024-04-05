package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityAboutScreenBinding


class AboutScreen : AppCompatActivity() {
    private lateinit var binding: ActivityAboutScreenBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.mainTitleTextView.text = "Calculator App"
        binding.textView.text = "\tWelcome to Calculator app for Android by Wiktor Ciszewski.\n" +
                "\tMy application provides a user-friendly interface for all your basic and advanced mathematical calculations. " +
                "\n\n\tThe Simple part of the calculator is designed for quick and straightforward calculations like adding (+), subtracting (-), multiplying (*) and division (/). " +
                "\n\n\tFor more complex mathematical needs, my Advanced Screen offers a range of additional functions and operations. " +
                "Key Features of the Advanced Calculator are: sqrt, ln, log, x^y, x^2, sin, cos, tan and percent"


    }
}