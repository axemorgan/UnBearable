package com.alex.morgan.bearlist.list

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import com.alex.morgan.bearlist.Bear
import com.alex.morgan.bearlist.R
import com.alex.morgan.bearlist.app.BearApplication
import javax.inject.Inject

class BearListActivity : AppCompatActivity(), BearListContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var presenter: BearListContract.Presenter

    private var recycler: RecyclerView? = null
    private var loadingView: View? = null
    private var loadingText: TextView? = null
    private var bearAdapter: BearAdapter? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        BearApplication.get()!!.bearListComponent.inject(this)

        this.setSupportActionBar(this.findViewById(R.id.toolbar))
        val actionBar = this.supportActionBar
        actionBar!!.setTitle(R.string.title)

        bearAdapter = BearAdapter()

        recycler = this.findViewById(R.id.kitten_recycler)
        recycler!!.layoutManager = LinearLayoutManager(this)
        recycler!!.adapter = bearAdapter
        recycler!!.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        loadingView = this.findViewById(R.id.loading_view)
        loadingText = this.findViewById(R.id.loading_text)

        swipeRefreshLayout = this.findViewById(R.id.swipe_refresher)
        swipeRefreshLayout!!.setOnRefreshListener(this)

        presenter!!.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.detachView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        MenuInflater(this).inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.rube_goldberg -> {
                run { presenter!!.onActivateRubeGoldbergMachine() }
                run { return super.onOptionsItemSelected(item) }
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun showBears(bears: Collection<Bear>) {
        recycler!!.visibility = VISIBLE
        loadingView!!.visibility = GONE
        bearAdapter!!.setBears(bears)
        swipeRefreshLayout!!.isRefreshing = false
    }

    override fun showLoading(text: String) {
        recycler!!.visibility = GONE
        loadingView!!.visibility = VISIBLE
        loadingText!!.text = text
    }

    override fun showError() {
        swipeRefreshLayout!!.isRefreshing = false
        Snackbar.make(recycler!!, "Uh oh... Something broke!", Snackbar.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Snackbar.make(recycler!!, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onRefresh() {
        presenter!!.onRefreshBears()
    }
}
