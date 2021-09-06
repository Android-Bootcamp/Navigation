package com.pinterest.bootcampnavigation_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_SENDER = "arg_sender"
private const val ARG_BODY = "arg_body"

class MessageFragment : Fragment() {

    lateinit var senderTextView: TextView
    lateinit var bodyTextView: TextView

    fun updateMessage(message: Message) {
        senderTextView.text = message.sender
        bodyTextView.text = message.body
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_message, container, false)

        senderTextView = rootView.findViewById(R.id.sender_text_view)
        bodyTextView = rootView.findViewById(R.id.body_text_view)

        arguments?.let {
            senderTextView.text = it.getString(ARG_SENDER)
            bodyTextView.text = it.getString(ARG_BODY)
        }

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MessageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_SENDER, param1)
                    putString(ARG_BODY, param2)
                }
            }
    }
}
