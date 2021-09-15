package com.example.bootcampnav_02

class MainPresenter : MVPPresenter, ViewListener {

    private var view: MVPView? = null

    override fun onBind(view: MVPView) {
        this.view = view
        view.setViewListener(this)
    }

    override fun onUnbind() {
        view = null
    }

    override fun onSetNameClicked() {
        view?.navigateToEditView()
    }

    override fun onNameSet(name: String?) {
        if (name != null) {
            view?.setName(view?.getContext()?.getString(R.string.hi_my_name_is_with_name, name) ?: "")
        } else {
            view?.setName(view?.getContext()?.getString(R.string.hi_my_name_is) ?: "")
        }
    }
}
