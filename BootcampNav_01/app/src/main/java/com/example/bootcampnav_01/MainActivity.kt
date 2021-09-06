package com.example.bootcampnav_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting our button and setting a click listener to it
        findViewById<Button>(R.id.secondActivityButton).setOnClickListener(::onSecondActivityButtonClicked)
    }

    private fun onSecondActivityButtonClicked(view: View) {
        // Creating a new intent
        Intent().apply {
            // We then call setClass to make the intent an explicit one
            setClass(this@MainActivity, SecondActivity::class.java)
        }.also {
            // and also call start activity with the newly create intent, which will be handled
            // by Android and result into opening our SecondActivity
            startActivity(it)
        }
    }
}
