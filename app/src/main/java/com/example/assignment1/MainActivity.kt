package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var calcButton: Button
    lateinit var buyButton: Button
    lateinit var buyCommButton: Button
    lateinit var sellButton: Button
    lateinit var sellCommButton: Button
    lateinit var noOfSharesButton: Button
    lateinit var totalTV: TextView

    lateinit var oneButton: Button
    lateinit var twoButton: Button
    lateinit var threeButton: Button
    lateinit var fourButton: Button
    lateinit var fiveButton: Button
    lateinit var sixButton: Button
    lateinit var sevenButton: Button
    lateinit var eightButton: Button
    lateinit var nineButton: Button
    lateinit var zeroButton: Button
    lateinit var dotButton: Button
    lateinit var clearButton: Button

    lateinit var myLayout: ConstraintLayout

    var activeTextView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myLayout = findViewById(R.id.MainLayout)

        calcButton = findViewById(R.id.calcButton)
        buyButton = findViewById(R.id.buyButton)
        buyCommButton = findViewById(R.id.buyCommButton)
        sellButton = findViewById(R.id.sellButton)
        sellCommButton = findViewById(R.id.sellCommButton)
        noOfSharesButton = findViewById(R.id.shareButton)
        totalTV = findViewById(R.id.totalTextView)

        oneButton = findViewById(R.id.oneButton)
        twoButton = findViewById(R.id.twoButton)
        threeButton = findViewById(R.id.threeButton)
        fourButton = findViewById(R.id.fourButton)
        fiveButton = findViewById(R.id.fiveButton)
        sixButton = findViewById(R.id.sixButton)
        sevenButton = findViewById(R.id.sevenButton)
        eightButton = findViewById(R.id.eightButton)
        nineButton = findViewById(R.id.nineButton)
        zeroButton = findViewById(R.id.zeroButton)
        dotButton = findViewById(R.id.dotButton)

        clearButton = findViewById(R.id.clearButton)

        calcButton.setOnClickListener {
           totalTV.setText(Calc())
        }

        buyButton.setOnClickListener {
            activeTextView = findViewById(R.id.buyTV)
        }

        buyCommButton.setOnClickListener {
            activeTextView = findViewById(R.id.buyCommTV)
        }

        sellButton.setOnClickListener {
            activeTextView = findViewById(R.id.sellTV)
        }
        sellCommButton.setOnClickListener {
            activeTextView = findViewById(R.id.sellCommTV)
        }
        noOfSharesButton.setOnClickListener {
            activeTextView = findViewById(R.id.shareTV)
        }

        oneButton.setOnClickListener {
            activeTextView?.text = activeTextView?.text.toString() + "1"
        }
        twoButton.setOnClickListener {
            activeTextView?.text = activeTextView?.text.toString() + "2"
        }
        threeButton.setOnClickListener {
            activeTextView?.text = activeTextView?.text.toString() + "3"
        }
        fourButton.setOnClickListener {
            activeTextView?.text = activeTextView?.text.toString() + "4"
        }
        fiveButton.setOnClickListener {
            activeTextView?.text = activeTextView?.text.toString() + "5"
        }
        sixButton.setOnClickListener {
            activeTextView?.text = activeTextView?.text.toString() + "6"
        }
        sevenButton.setOnClickListener {
            activeTextView?.text = activeTextView?.text.toString() + "7"
        }
        eightButton.setOnClickListener {
            activeTextView?.text = activeTextView?.text.toString() + "8"
        }
        nineButton.setOnClickListener {
            activeTextView?.text = activeTextView?.text.toString() + "9"
        }
        zeroButton.setOnClickListener {
            activeTextView?.text = activeTextView?.text.toString() + "0"
        }
        dotButton.setOnClickListener {
            if(activeTextView?.text?.contains(".") == false){
                activeTextView?.text = activeTextView?.text.toString() + "."
            }
            else{
                Snackbar.make(myLayout, "Error: You have entered a dot already", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Close", View.OnClickListener{
                        activeTextView?.text = null
                    }).show()
            }
        }

        clearButton.setOnClickListener {
            findViewById<TextView>(R.id.shareTV).text = ""
            findViewById<TextView>(R.id.sellTV).text = ""
            findViewById<TextView>(R.id.sellCommTV).text = ""
            findViewById<TextView>(R.id.buyTV).text = ""
            findViewById<TextView>(R.id.buyCommTV).text = ""
            findViewById<TextView>(R.id.totalTextView).text = ""
        }




    }

    fun Calc():String{
        val shareTV: TextView = findViewById(R.id.shareTV)

        val sellSide: Float = (((100- findViewById<TextView>(R.id.sellCommTV).text.toString().toFloat()) / 100) * findViewById<TextView>(R.id.sellTV).text.toString().toFloat() * shareTV.text.toString().toFloat())
        val buySide: Float = (((100 + findViewById<TextView>(R.id.buyCommTV).text.toString().toFloat()) / 100) * findViewById<TextView>(R.id.buyTV).text.toString().toFloat() * shareTV.text.toString().toFloat())
        val total: Float = sellSide - buySide

        return total.toString()
    }
}