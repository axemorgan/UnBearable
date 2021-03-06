package com.alex.morgan.bearlist

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.alex.morgan.bearlist.list.BearAdapter
import com.alex.morgan.bearlist.list.BearListActivity
import com.alex.morgan.bearlist.list.BearListContract
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_bear_list.*
import javax.inject.Inject

class BearListFragment : Fragment(), BearListContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var presenter: BearListContract.Presenter

    private lateinit var bearAdapter: BearAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bear_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bearAdapter = BearAdapter {
            presenter.onShowBearDetail(it)
        }

        bear_recycler.layoutManager = LinearLayoutManager(view.context)
        bear_recycler.adapter = bearAdapter
        bear_recycler.addItemDecoration(
            DividerItemDecoration(
                view.context,
                DividerItemDecoration.VERTICAL
            )
        )
        swipe_refresher.setOnRefreshListener(this)

        presenter.attachView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.rube_goldberg -> {
                presenter.onActivateRubeGoldbergMachine()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun showBears(bears: Collection<Bear>) {
        bear_recycler.visibility = View.VISIBLE
        loading_view.visibility = View.GONE
        bearAdapter.setBears(bears)
        swipe_refresher.isRefreshing = false
    }

    override fun showLoading(text: String) {
        bear_recycler.visibility = View.GONE
        loading_view.visibility = View.VISIBLE
        loading_text.text = text
    }

    override fun navigateToBearDetail(bear: Bear) {
        (requireActivity() as BearListActivity).showBearDetail(bear)
    }

    override fun showError() {
        swipe_refresher.isRefreshing = false
        Snackbar.make(bear_recycler, "Uh oh... Something broke!", Snackbar.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Snackbar.make(bear_recycler, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onRefresh() {
        presenter.onRefreshBears()
    }
}
