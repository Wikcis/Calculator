package com.example.calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityHomeScreenBinding
import kotlin.system.exitProcess

class HomeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.simpleCalcButton.setOnClickListener {
            val intent = Intent(this, SimpleCalcScreen::class.java)
            startActivity(intent)
        }
        binding.advancedCalcButton.setOnClickListener {
            val intent = Intent(this, AdvancedCalcScreen::class.java)
            startActivity(intent)
        }
        binding.aboutButton.setOnClickListener {
            val intent = Intent(this, AboutScreen::class.java)
            startActivity(intent)
        }
        binding.exitButton.setOnClickListener {
            finish();
            exitProcess(0);
        }
    }
}