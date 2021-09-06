package com.pinterest.bootcampnavigation_03

interface ListActionListener {
    /**
     * Called when users tap on a message
     *
     * @param message
     */
    fun onMessageClicked(message: Message)
}