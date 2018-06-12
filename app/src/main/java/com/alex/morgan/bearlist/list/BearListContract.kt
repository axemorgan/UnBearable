package com.alex.morgan.bearlist.list

import com.alex.morgan.bearlist.Bear

interface BearListContract {
    interface View {
        fun showBears(bears: Collection<Bear>)

        fun showLoading(text: String)

        fun showError()

        fun showMessage(message: String)
    }

    interface Presenter {
        fun attachView(view: View)

        fun detachView()

        fun onRefreshBears()

        fun onShowBearDetail(bear: Bear)

        fun onActivateRubeGoldbergMachine()
    }
}
