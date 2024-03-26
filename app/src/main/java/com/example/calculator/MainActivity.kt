package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.zeroButton.setOnClickListener{
            if(binding.resultView.text != "0"){
                binding.resultView.append("0")
            }
        }
        binding.oneButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            binding.resultView.append("1")
        }
        binding.twoButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            binding.resultView.append("2")
        }
        binding.threeButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            binding.resultView.append("3")
        }
        binding.fourButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            binding.resultView.append("4")
        }
        binding.fiveButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            binding.resultView.append("5")
        }
        binding.sixButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            binding.resultView.append("6")
        }
        binding.sevenButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            binding.resultView.append("7")
        }
        binding.eightButton.setOnClickListener{
            Log.d("co to za string", "| " + binding.resultView.text.toString() + " | ")
            if(binding.resultView.text == "0"){
                binding.resultView.text = ""
            }
            binding.resultView.append("8")
        }
        binding.nineButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            binding.resultView.append("9")
        }
        binding.addButton.setOnClickListener{
            binding.resultView.append("+")
        }
        binding.subtractButton.setOnClickListener{
            binding.resultView.append("-")
        }
        binding.divisionButton.setOnClickListener{
            binding.resultView.append("÷")
        }
        binding.multiplyButton.setOnClickListener{
            binding.resultView.append("×")
        }
        binding.dotButton.setOnClickListener{
            binding.resultView.append(".")
        }
        binding.allClearButton.setOnClickListener{
            Log.d("Log", binding.resultView.text.length.toString())
            binding.resultView.text = "0"
            Log.d("Log", binding.resultView.text.length.toString())
        }
        binding.clearButton.setOnClickListener{

            if(binding.resultView.text.isNotEmpty()){
                binding.resultView.text = binding.resultView.text.dropLast(1)
                if(binding.resultView.text.isEmpty()){
                    binding.resultView.text = "0"
                }
            }

        }
    }

    private fun checkIfThereIsOnlyZero(){
        if(binding.resultView.text == "0"){
            binding.resultView.text = ""
        }
    }
}