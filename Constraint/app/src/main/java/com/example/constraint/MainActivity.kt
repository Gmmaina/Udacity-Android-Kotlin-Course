package com.example.constraint

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var boxThreeText: View
    private lateinit var boxFourText: View
    private lateinit var boxFiveText: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()
    }

    private fun setListeners() {
        val main = findViewById<View>(R.id.main)
        val boxOneText = findViewById<View>(R.id.box_one_text)
        val boxTwoText = findViewById<View>(R.id.box_two_text)

        boxThreeText = findViewById(R.id.box_three_text)
        boxFourText = findViewById(R.id.box_four_text)
        boxFiveText = findViewById(R.id.box_five_text)

        val redButton = findViewById<Button>(R.id.red_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)
        val greenButton = findViewById<Button>(R.id.green_button)

        val clickableViews: List<View> =
            listOf(main,boxOneText,boxTwoText,boxThreeText,boxFourText,boxFiveText,redButton,yellowButton,greenButton)

        for (item in clickableViews){
            item.setOnClickListener{ makeColored(it) }
        }
    }

    private
    fun makeColored(view: View) {
        when(view.id){
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_button -> boxThreeText.setBackgroundResource(R.color.red)
            R.id.yellow_button -> boxFourText.setBackgroundResource(R.color.yellow)
            R.id.green_button -> boxFiveText.setBackgroundResource(R.color.green)

            else -> view.setBackgroundColor(Color.LTGRAY)

        }
    }
}