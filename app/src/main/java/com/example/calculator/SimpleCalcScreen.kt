package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class SimpleCalcScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var expression = "0"

    private var operation = false

    @SuppressLint("SetTextI18n")
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
            checkIfThereIsOnlyZero()
            checkIfThereIsOperation()
            binding.resultView.append("0")
            binding.expressionTextView.append("0")
        }
        binding.oneButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            checkIfThereIsOperation()
            binding.resultView.append("1")
            binding.expressionTextView.append("1")
        }
        binding.twoButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            checkIfThereIsOperation()
            binding.resultView.append("2")
            binding.expressionTextView.append("2")
        }
        binding.threeButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            checkIfThereIsOperation()
            binding.resultView.append("3")
            binding.expressionTextView.append("3")
        }
        binding.fourButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            checkIfThereIsOperation()
            binding.resultView.append("4")
            binding.expressionTextView.append("4")
        }
        binding.fiveButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            checkIfThereIsOperation()
            binding.resultView.append("5")
            binding.expressionTextView.append("5")
        }
        binding.sixButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            checkIfThereIsOperation()
            binding.resultView.append("6")
            binding.expressionTextView.append("6")
        }
        binding.sevenButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            checkIfThereIsOperation()
            binding.resultView.append("7")
            binding.expressionTextView.append("7")
        }
        binding.eightButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            checkIfThereIsOperation()
            binding.resultView.append("8")
            binding.expressionTextView.append("8")
        }
        binding.nineButton.setOnClickListener{
            checkIfThereIsOnlyZero()
            checkIfThereIsOperation()
            binding.resultView.append("9")
            binding.expressionTextView.append("9")
        }
        binding.addButton.setOnClickListener{
            checkIfLastCharIsDigit()
            if(!operation){
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("+")
        }
        binding.subtractButton.setOnClickListener{
            checkIfLastCharIsDigit()
            if(!operation){
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("-")
        }
        binding.divisionButton.setOnClickListener{
            checkIfLastCharIsDigit()
            if(!operation){
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("/")
        }
        binding.multiplyButton.setOnClickListener{
            checkIfLastCharIsDigit()
            if(!operation){
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("*")
        }
        binding.dotButton.setOnClickListener{
            if(!binding.resultView.text.contains(".")){
                binding.resultView.append(".")
                binding.expressionTextView.append(".")
            }
        }
        binding.allClearButton.setOnClickListener{
            operation = false
            binding.resultView.text = "0"
            binding.expressionTextView.text = "0"
        }
        binding.clearButton.setOnClickListener{
            operation = false
            if(binding.resultView.text.isNotEmpty()){
                binding.resultView.text = binding.resultView.text.dropLast(1)
                binding.expressionTextView.text = binding.expressionTextView.text.dropLast(1)
                if(binding.resultView.text.isEmpty()){
                    binding.resultView.text = "0"
                    binding.expressionTextView.text = "0"
                }
            }

        }
        binding.plusMinusButton.setOnClickListener {
            Log.d("asdasd", binding.expressionTextView.text.toString())
            Log.d("drugie", binding.resultView.text.toString())
            if(binding.resultView.text.toString().toFloat() > 0) {
                var t = binding.resultView.text
                t = "-$t"
                binding.resultView.text = t
                binding.expressionTextView.text = binding.expressionTextView.text.dropLast(t.length-1)
                binding.expressionTextView.append(t)

            } else if(binding.resultView.text.toString().toFloat() < 0){
                binding.resultView.text = (binding.resultView.text.toString().toFloat() * -1).toString()
                binding.expressionTextView.text = binding.expressionTextView.text.dropLast(binding.resultView.text.length+1)
                binding.expressionTextView.append(binding.resultView.text)
            } else{
                if(binding.expressionTextView.text == "-0"){
                    binding.expressionTextView.text = binding.expressionTextView.text.drop(1)
                    binding.resultView.text = binding.resultView.text.drop(1)
                }else{
                    val tmp = binding.expressionTextView.text.toString().toFloat()
                    binding.expressionTextView.text = (-tmp).toString()
                    binding.resultView.text = binding.expressionTextView.text
                }
            }
        }

        binding.resultButton.setOnClickListener{
            operation = false
            checkIfLastCharIsDigit()
            evaluateExpression()
        }
    }
    private fun checkIfLastCharIsDigit(){
        if(!binding.expressionTextView.text.last().isDigit()){
            binding.expressionTextView.text = binding.expressionTextView.text.dropLast(1)
        }
    }
    @SuppressLint("RtlHardcoded")
    private fun evaluateExpression(){
        try{
            val result = ExpressionBuilder(binding.expressionTextView.text.toString()).build().evaluate()
            binding.resultView.text = result.toString()
            binding.expressionTextView.text = result.toString()

        }catch (ex : ArithmeticException) {
            val t = Toast.makeText(applicationContext, "Division by zero!", Toast.LENGTH_SHORT)
            t.show()
            Log.e("error", ex.toString())
            binding.expressionTextView.text = "0"
            binding.resultView.text = "0"
        }
    }
    private fun checkIfThereIsOnlyZero(){
        if(binding.resultView.text.toString() == "0" || binding.resultView.text.toString() == "-0"){
            binding.resultView.text = binding.resultView.text.dropLast(1)
            binding.expressionTextView.text = binding.expressionTextView.text.dropLast(1)
        }
    }
    private fun checkIfThereIsOperation(){
        if(operation){
            binding.resultView.text = ""
            operation = false
        }

    }
}