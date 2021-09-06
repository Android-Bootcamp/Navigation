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
    private val editNameRequestCode = 1


    // This is how we would set the callbacks the new way
    //private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
    //    if (result.resultCode == Activity.RESULT_OK) {
    //        val name = result.data?.extras?.getString(INTENT_EXTRAS_KEY_NAME) ?: getString(R.string.hi_my_name_is)

    //        nameTextView.text = getString(R.string.hi_my_name_is_with_name, name)
    //    }
    //}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameTextView = findViewById(R.id.name_text_view)

        findViewById<Button>(R.id.edit_name_button).setOnClickListener {
            // Current implementation.. soon to be deprecated (see comment below)
            startActivityForResult(Intent(this@MainActivity, EditTextActivity::class.java), editNameRequestCode)

            // startActivityForResult will soon be deprecated and will be replaced with ActivityResult Contracts
            // For more info, https://developer.android.com/training/basics/intents/result
            // This is how you would launch the intent the new way
            // startForResult.launch(Intent(this@MainActivity, EditTextActivity::class.java))
        }
    }

    // This callback will soon be deprecated. You'd use the code in line 19 to handle the result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == editNameRequestCode && resultCode == RESULT_OK) {
            val name = data?.extras?.getString(INTENT_EXTRAS_KEY_NAME)  ?: getString(R.string.hi_my_name_is)

            nameTextView.text = getString(R.string.hi_my_name_is_with_name, name)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}