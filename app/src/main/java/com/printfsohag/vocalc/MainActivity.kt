package com.printfsohag.vocalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.cmnhs.cmtools.R
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var minutesEditText : EditText
    private lateinit var secondsEditText : EditText
    private lateinit var costPerMinuteEditText : EditText
    private lateinit var calculateButton : Button
    private lateinit var totalCostTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)

        supportActionBar


        minutesEditText = findViewById(R.id.minutesEditText)
        secondsEditText = findViewById(R.id.secondsEditText)
        costPerMinuteEditText = findViewById(R.id.costPerMinuteEditText)
        calculateButton = findViewById(R.id.calculateButton)
        totalCostTextView = findViewById(R.id.totalCostTextView)

        calculateButton.setOnClickListener {
        voiceCalculator()
        }


    }

    private fun voiceCalculator() {
        if (minutesEditText.text.isNullOrEmpty() || secondsEditText.text.isNullOrEmpty() || costPerMinuteEditText.text.isNullOrEmpty()) {
            Toast.makeText(this, "Please enter all values!", Toast.LENGTH_SHORT).show()
            return
        }

        val minutesDouble = minutesEditText.text.toString().toDoubleOrNull() ?: return
        val secondsDouble = secondsEditText.text.toString().toDoubleOrNull() ?: return
        val cpmDouble = costPerMinuteEditText.text.toString().toDoubleOrNull() ?: return

        val totalMinutes: Double = minutesDouble + (secondsDouble / 60.0)
        val totalCost: Double = totalMinutes * cpmDouble
        val formattedTotalCost = String.format("%.2f", totalCost)
        val formattedTotalCostString = "${getString(R.string.total_cost_empty)} $formattedTotalCost Taka"

        totalCostTextView.visibility = View.VISIBLE
        totalCostTextView.text = formattedTotalCostString
    }

}