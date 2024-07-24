package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName =MyName("GIDEON MAINA")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName

        binding.doneBtn.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        binding.apply {
//            nicknameText.text = binding.nicknameEt.text

            myName?.nickname = nicknameEt.text.toString()
            invalidateAll()
            nicknameEt.visibility = View.GONE
            doneBtn.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide input keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }


}