package com.example.bootcampnav_02

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val INTENT_EXTRAS_KEY_NAME = "intentExtrasKeyName"

class MainActivity : AppCompatActivity(), MVPView {

    private var viewListener: ViewListener? = null
    private lateinit var nameTextView: TextView
    private val editNameRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainPresenter().onBind(this)

        setContentView(R.layout.activity_main)

        nameTextView = findViewById(R.id.name_text_view)

        findViewById<Button>(R.id.edit_name_button).setOnClickListener {
            viewListener?.onSetNameClicked()
        }
    }

    override fun navigateToEditView() {
        startActivityForResult(Intent(this@MainActivity, EditTextActivity::class.java), editNameRequestCode)
    }

    override fun setName(name: String) {
        nameTextView.text = name
    }

    override fun getContext(): Context = this

    override fun onDestroy() {
        super.onDestroy()
        this.viewListener = null
    }

    override fun setViewListener(viewListener: ViewListener) {
        this.viewListener = viewListener
    }


    // This callback will soon be deprecated. You'd use the code in line 19 to handle the result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == editNameRequestCode && resultCode == RESULT_OK) {
            viewListener?.onNameSet(data?.extras?.getString(INTENT_EXTRAS_KEY_NAME))

        }
        super.onActivityResult(requestCode, resultCode, data)
    }



}