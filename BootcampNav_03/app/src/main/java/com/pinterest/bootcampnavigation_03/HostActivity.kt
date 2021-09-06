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
        val messageFragment = supportFragmentManager.findFragmentById(R.id.detail_fragment) as? MessageFragment

        // If the fragment does not exist, we add it to the stack (Portrait Mode)
        if (messageFragment == null || !messageFragment.isInLayout) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, MessageFragment.newInstance(message.sender, message.body))
                .addToBackStack(null)
                .commit()
        } else {
            // Otherwise, we update it's contents (Landscape mode)
            messageFragment.updateMessage(message)
        }
    }
}
