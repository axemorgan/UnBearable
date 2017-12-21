package com.alex.morgan.bearlist.list;

import com.alex.morgan.bearlist.Bear;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class BearListPresenter implements BearListContract.Presenter, BearFetcher.Callback {

    private final BearFetcher bearFetcher;

    private BearListContract.View view;

    @Inject
    BearListPresenter(BearFetcher bearFetcher) {
        this.bearFetcher = bearFetcher;
    }

    @Override
    public void attachView(BearListContract.View view) {
        this.view = view;
        this.startLoading();
        bearFetcher.fetchBears(this, false);
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onRefreshBears() {
        bearFetcher.fetchBears(this, true);
    }

    @Override
    public void onShowBearDetail(Bear bear) {
        //TODO
    }

    private void startLoading() {
        int loadingCounter = (int) System.currentTimeMillis() % 3;
        String loadingText;
        switch (loadingCounter) {
            case 0:
                loadingText = "Bear with me...";
                break;
            case 1:
                loadingText = "This should bearly take a second...";
                break;
            case 2:
                loadingText = "Fetching the bear necessities...";
                break;
            default:
                throw new RuntimeException();
        }

        view.showLoading(loadingText);
    }

    @Override
    public void onBears(Collection<Bear> bears) {
        view.showBears(bears);
    }

    @Override
    public void onError() {
        view.showError();
    }
}
