package com.example.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {


    lateinit var textView: TextView
    lateinit var textView2: TextView
    lateinit var numberText: EditText
    lateinit var numberReset: ImageButton
    lateinit var numberCheck: ImageButton

    var random: Int = nextInt(1,1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        numberText = findViewById(R.id.numberText)
        numberReset = findViewById(R.id.numberReset)
        numberCheck = findViewById(R.id.numberCheck)

        textView.text = "Guess number from 1 - 1000"

        numberCheck.setOnClickListener {
            val number:Int = numberText.text.toString().toInt()

            if (number < random){
                textView2.text = "Wrong your number is higher!"
                numberText.text.clear()
            }
            else if (number > random){
                textView2.text = "Wrong your number is lower!"
                numberText.text.clear()
            }
            else {
                textView2.text = "YOU ARE THE WINNER!"
                numberText.text.clear()
            }
        }
        numberReset.setOnClickListener{
            reset()

        }

    }
    fun reset() {
        random = nextInt(1, 1000)
        textView2.text = "Please enter your number"
        numberText.text.clear()
    }
}