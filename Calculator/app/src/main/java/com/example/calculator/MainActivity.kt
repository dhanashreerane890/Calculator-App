package com.example.calculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var value: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_00.setOnClickListener {


            appendOnClick(true, "00")

        }
        btn_0.setOnClickListener {

            appendOnClick(true, "0")

        }
        btn_dot.setOnClickListener {

            appendOnClick(true, ".")

        }
        btn_1.setOnClickListener {

            appendOnClick(true, "1")

        }
        btn_2.setOnClickListener {

            appendOnClick(true, "2")

        }
        btn_3.setOnClickListener {

            appendOnClick(true, "3")

        }
        btn_4.setOnClickListener {

            appendOnClick(true, "4")

        }
        btn_5.setOnClickListener {

            appendOnClick(true, "5")

        }
        btn_6.setOnClickListener {
            appendOnClick(true, "6")

        }
        btn_7.setOnClickListener {
            appendOnClick(true, "7")


        }
        btn_8.setOnClickListener {

            appendOnClick(true, "8")

        }
        btn_9.setOnClickListener {

            appendOnClick(true, "9")
        }
        btn_plus.setOnClickListener {

            appendOnClick(false, "+")
        }
        btn_subtraction.setOnClickListener {

            appendOnClick(false, "-")
        }
        btn_multiPly.setOnClickListener {

            appendOnClick(false, "×")
        }
        btn_clear.setOnClickListener {

            if (tvTextLocal.text.isNotEmpty()) {
                var back = tvTextLocal.text.toString()
                back = back.substring(0, back.length - 1)
                tvTextLocal.text = back
            }
        }
        btn_Percentage.setOnClickListener {

            appendOnClick(false, "%")
        }
        btnClearAll.setOnClickListener {
            tvTextLocal.text = ""
            tvTextFinal.text = ""
        }
        btn_divide.setOnClickListener {
            appendOnClick(false, "÷")

        }

        btn_equal.setOnClickListener {


            value = tvTextLocal.getText().toString();
            value = value.replace("×", "*");
            value = value.replace("%", "/100");
            value = value.replace("÷", "/");
            calculate(value)


        }
    }

    private fun appendOnClick(clear: Boolean, string: String) {

        if (clear) {
            tvTextFinal.text = ""
            tvTextLocal.append(string)
        } else {
            tvTextLocal.append(tvTextFinal.text)
            tvTextLocal.append(string)
            tvTextFinal.text = ""
        }
    }

    private fun calculate(value: String) {

        try {
            val input = ExpressionBuilder(value).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if (output == longOutput.toDouble()) {
                tvTextFinal.text = longOutput.toString()
            } else {
                tvTextFinal.text = output.toString()
            }

        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }


}