package com.alex.morgan.bearlist.list

import com.alex.morgan.bearlist.Bear
import com.alex.morgan.bearlist.app.ActivityScope
import dagger.Lazy
import javax.inject.Inject

@ActivityScope
internal class BearListPresenter @Inject
constructor(private val bearFetcher: BearFetcher, private val machine: Lazy<RubeGoldbergMachine>) :
    BearListContract.Presenter, BearFetcher.Callback {

    private var view: BearListContract.View? = null

    override fun attachView(view: BearListContract.View) {
        this.view = view
        this.startLoading()
        bearFetcher.fetchBears(this, false)
    }

    override fun detachView() {
        this.view = null
    }

    override fun onRefreshBears() {
        bearFetcher.fetchBears(this, true)
    }

    override fun onShowBearDetail(bear: Bear) {
        //TODO
    }

    override fun onActivateRubeGoldbergMachine() {
        machine.get().activate()
        view!!.showMessage("Done.")
    }

    private fun startLoading() {
        val loadingCounter = (System.currentTimeMillis() % 3).toInt()
        val loadingText: String
        when (loadingCounter) {
            0 -> loadingText = "Bear with me..."
            1 -> loadingText = "This should bearly take a second..."
            2 -> loadingText = "Fetching the bear necessities..."
            else -> throw RuntimeException("Loading counter was $loadingCounter")
        }

        view!!.showLoading(loadingText)
    }

    override fun onBears(bears: Collection<Bear>) {
        view!!.showBears(bears)
    }

    override fun onError() {
        view!!.showError()
    }
}
