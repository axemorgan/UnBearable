package com.alex.morgan.bearlist.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.alex.morgan.bearlist.Bear;
import com.alex.morgan.bearlist.R;
import com.alex.morgan.bearlist.app.BearApplication;

import java.util.Collection;

import javax.inject.Inject;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity implements BearListContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    BearListContract.Presenter presenter;

    private RecyclerView recycler;
    private View loadingView;
    private TextView loadingText;
    private BearAdapter bearAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        BearApplication.get().getBearListComponent().inject(this);

        this.setSupportActionBar(this.<Toolbar>findViewById(R.id.toolbar));
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle(R.string.title);

        bearAdapter = new BearAdapter();

        recycler = this.findViewById(R.id.kitten_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(bearAdapter);
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        loadingView = this.findViewById(R.id.loading_view);
        loadingText = this.findViewById(R.id.loading_text);

        swipeRefreshLayout = this.findViewById(R.id.swipe_refresher);
        swipeRefreshLayout.setOnRefreshListener(this);

        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rube_goldberg: {
                presenter.onActivateRubeGoldbergMachine();
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    @Override
    public void showBears(Collection<Bear> bears) {
        recycler.setVisibility(VISIBLE);
        loadingView.setVisibility(GONE);
        bearAdapter.setBears(bears);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showLoading(String text) {
        recycler.setVisibility(GONE);
        loadingView.setVisibility(VISIBLE);
        loadingText.setText(text);
    }

    @Override
    public void showError() {
        swipeRefreshLayout.setRefreshing(false);
        Snackbar.make(recycler, "Uh oh... Something broke!", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(recycler, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        presenter.onRefreshBears();
    }
}
