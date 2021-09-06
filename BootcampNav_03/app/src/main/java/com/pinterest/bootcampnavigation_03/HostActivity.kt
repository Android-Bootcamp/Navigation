package com.pinterest.bootcampnavigation_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class HostActivity : AppCompatActivity(), ListActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
    }

    override fun onMessageClicked(message: Message) {
        // TODO: Replace this Toast with navigation!
        Toast.makeText(this, "Message clicked: ${message.body}", Toast.LENGTH_LONG).show()
    }
}
