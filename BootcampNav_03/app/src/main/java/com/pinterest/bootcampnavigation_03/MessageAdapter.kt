package com.pinterest.bootcampnavigation_03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class MessageViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var senderTextView: TextView = view.findViewById(R.id.sender_text_view)
    var timestampTextView: TextView = view.findViewById(R.id.timestamp_text_view)
}

class MessageAdapter(messageAdapter: MessageList): RecyclerView.Adapter<MessageViewHolder>() {

    var list: List<Message> = messageAdapter.getList()
    var formatter = SimpleDateFormat("yyyy-MM-dd")
    private var listActionListener: ListActionListener? = null

    fun setListener(listener: ListActionListener) {
        this.listActionListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.message_item_view, parent, false)

        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = list[position]

        holder.apply {
            senderTextView.text = message.sender
            timestampTextView.text = formatter.format(message.timestamp)

            itemView.setOnClickListener {
                listActionListener?.onMessageClicked(message)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}
