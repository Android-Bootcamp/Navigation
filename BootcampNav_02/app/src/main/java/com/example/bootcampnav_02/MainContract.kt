package com.example.bootcampnav_02

import android.content.Context

interface ViewListener {
    fun onSetNameClicked()

    fun onNameSet(name: String?)
}

interface MVPView {
    fun setViewListener(viewListener: ViewListener)

    fun navigateToEditView()

    fun setName(name: String)

    fun getContext(): Context
}

interface MVPPresenter {
    fun onBind(view: MVPView)

    fun onUnbind()
}