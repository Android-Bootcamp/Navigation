package com.example.bootcampnav_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditTextActivity : AppCompatActivity() {

    lateinit var nameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        nameEditText = findViewById(R.id.name_edit_text)

        findViewById<Button>(R.id.save_button).setOnClickListener {
            val intent = Intent().apply {
                putExtra(INTENT_EXTRAS_KEY_NAME, nameEditText.text.toString())
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
