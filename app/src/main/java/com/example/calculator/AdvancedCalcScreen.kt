package com.example.calculator

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityAdvancedCalcScreenBinding
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException

class AdvancedCalcScreen : AppCompatActivity() {

    private lateinit var binding: ActivityAdvancedCalcScreenBinding

    private var operation = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvancedCalcScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.zeroButton.setOnClickListener {
            if(binding.resultView.text.length <= blockSize() || operation) {
                checkIfAddingDigitsIsPossible()
                appendCharToView("0")
            }
        }

        binding.oneButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfAddingDigitsIsPossible()
                appendCharToView("1")
            }
        }

        binding.twoButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfAddingDigitsIsPossible()
                appendCharToView("2")
            }
        }

        binding.threeButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfAddingDigitsIsPossible()
                appendCharToView("3")
            }
        }

        binding.fourButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfAddingDigitsIsPossible()
                appendCharToView("4")
            }
        }

        binding.fiveButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfAddingDigitsIsPossible()
                appendCharToView("5")
            }
        }

        binding.sixButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfAddingDigitsIsPossible()
                appendCharToView("6")
            }
        }

        binding.sevenButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfAddingDigitsIsPossible()
                appendCharToView("7")
            }
        }

        binding.eightButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfAddingDigitsIsPossible()
                appendCharToView("8")
            }
        }

        binding.nineButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfAddingDigitsIsPossible()
                appendCharToView("9")
            }
        }

        binding.addButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("+")
        }

        binding.subtractButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("-")
        }

        binding.divisionButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("/")
        }

        binding.multiplyButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("*")
        }

        binding.dotButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfThereIsInfinity()
                if (!binding.resultView.text.contains(".")) {
                    appendCharToView(".")
                }
            }
        }

        binding.logButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            val exp = "log10(" + binding.expressionTextView.text + ")"
            binding.expressionTextView.text = exp
            evaluateExpression()
        }

        binding.lnButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true

            val exp = "log(" + binding.expressionTextView.text + ")"
            binding.expressionTextView.text = exp

            evaluateExpression()
        }

        binding.sinButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true

            val exp = "sin(" + binding.expressionTextView.text + ")"
            binding.expressionTextView.text = exp

            evaluateExpression()
        }

        binding.cosButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true

            val exp = "cos(" + binding.expressionTextView.text + ")"
            binding.expressionTextView.text = exp

            evaluateExpression()
        }

        binding.tanButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true

            val exp = "tan(" + binding.expressionTextView.text + ")"
            binding.expressionTextView.text = exp

            evaluateExpression()
        }

        binding.sqrtButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true

            val exp = "sqrt(" + binding.expressionTextView.text + ")"
            binding.expressionTextView.text = exp

            evaluateExpression()
        }

        binding.squareButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("^2")

            evaluateExpression()
        }

        binding.powerButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("^")
        }

        binding.percentButton.setOnClickListener {
            checkIfThereIsInfinity()
            checkIfLastCharIsNotDigit()
            if (!operation) {
                evaluateExpression()
                binding.resultView.text = binding.expressionTextView.text
            }
            operation = true
            binding.expressionTextView.append("/100")
            evaluateExpression()
        }

        binding.allClearButton.setOnClickListener {
            operation = false
            clearViewToZero()
        }

        binding.clearButton.setOnClickListener {
            checkIfThereIsInfinity()
            operation = false
            if (binding.resultView.text.isNotEmpty()) {
                binding.resultView.text = binding.resultView.text.dropLast(1)
                binding.expressionTextView.text = binding.expressionTextView.text.dropLast(1)
                if (binding.resultView.text.isEmpty()) {
                    clearViewToZero()
                }
            }
        }

        binding.plusMinusButton.setOnClickListener {
            if (binding.resultView.text.length <= blockSize() || operation) {
                checkIfThereIsInfinity()
                if (binding.resultView.text.toString().toDouble() > 0) {
                    var t = binding.resultView.text
                    t = "-$t"
                    binding.resultView.text = t
                    binding.expressionTextView.text =
                        binding.expressionTextView.text.dropLast(t.length - 1)
                    binding.expressionTextView.append(t)

                } else if (binding.resultView.text.toString().toDouble() < 0) {
                    binding.resultView.text =
                        (binding.resultView.text.toString().toDouble() * -1).toString()
                    binding.expressionTextView.text =
                        binding.expressionTextView.text.dropLast(binding.resultView.text.length + 1)
                    binding.expressionTextView.append(binding.resultView.text)
                } else {
                    if (binding.expressionTextView.text == "-0") {
                        binding.expressionTextView.text = binding.expressionTextView.text.drop(1)
                        binding.resultView.text = binding.resultView.text.drop(1)
                    } else {
                        val tmp = binding.expressionTextView.text.toString().toDouble()
                        binding.expressionTextView.text = (-tmp).toString()
                        binding.resultView.text = binding.expressionTextView.text
                    }
                }
            }
        }

        binding.resultButton.setOnClickListener {
            operation = false
            checkIfLastCharIsNotDigit()
            evaluateExpression()
        }
    }

    private fun appendCharToView(chr: String) {
        binding.resultView.append(chr)
        binding.expressionTextView.append(chr)
    }

    private fun blockSize(): Int {
        return if (getResources().configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            12
        } else 45
    }

    private fun checkIfLastCharIsNotDigit() {
        if (binding.expressionTextView.text.isNotEmpty() && !binding.expressionTextView.text.last().isDigit()) {
            binding.expressionTextView.text = binding.expressionTextView.text.dropLast(1)
        }
    }
    private fun checkIfNaN(){
        if(binding.expressionTextView.text.toString().compareTo("NaN") == 0) {
            makeToastWithText("Not a Number!")
        }
    }

    @SuppressLint("RtlHardcoded")
    private fun evaluateExpression() {
        try {
            val result =
                ExpressionBuilder(binding.expressionTextView.text.toString()).build().evaluate()
            binding.resultView.text = result.toString()
            binding.expressionTextView.text = result.toString()

        } catch (ex: ArithmeticException) {
            makeToastWithText("Division by zero!")
        } catch (ex: UnknownFunctionOrVariableException) {
            makeToastWithText("Value exceeds data limit!")
        }
        checkIfNaN()
    }
    private fun checkIfAddingDigitsIsPossible() {
        checkIfThereIsInfinity()
        checkIfThereIsOnlyZero()
        checkIfThereIsOperation()
    }
    private fun makeToastWithText(text: String) {
        val t = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
        t.show()
        clearViewToZero()
    }
    private fun clearViewToZero() {
        binding.expressionTextView.text = "0"
        binding.resultView.text = "0"
    }
    private fun checkIfThereIsOnlyZero() {
        if (binding.resultView.text.toString() == "0" || binding.resultView.text.toString() == "-0") {
            binding.resultView.text = binding.resultView.text.dropLast(1)
            binding.expressionTextView.text = binding.expressionTextView.text.dropLast(1)
        }
    }

    private fun checkIfThereIsOperation() {
        if (operation) {
            binding.resultView.text = ""
            operation = false
        }
    }
    private fun checkIfThereIsInfinity() {
        var counter = 0
        for (chr in binding.resultView.text) {
            if (chr.isLetter() && chr!='E'){
                counter++
            }
        }
        if (counter > 0){
            clearViewToZero()
            operation = false
        }
    }
}