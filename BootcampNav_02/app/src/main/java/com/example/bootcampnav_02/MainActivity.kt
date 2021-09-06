package com.example.bootcampnav_02

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

const val INTENT_EXTRAS_KEY_NAME = "intentExtrasKeyName"

class MainActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val name = result.data?.extras?.getString(INTENT_EXTRAS_KEY_NAME) ?: getString(R.string.hi_my_name_is)

            nameTextView.text = getString(R.string.hi_my_name_is_with_name, name)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameTextView = findViewById(R.id.name_text_view)

        findViewById<Button>(R.id.edit_name_button).setOnClickListener {
            startForResult.launch(Intent(this@MainActivity, EditTextActivity::class.java))
        }
    }
}