package com.alex.morgan.bearlist.list;

import com.alex.morgan.bearlist.Bear;

import java.util.Collection;

interface BearListContract {
    interface View {
        void showBears(Collection<Bear> bears);

        void showLoading(String text);

        void showError();
    }

    interface Presenter {
        void attachView(View view);

        void detachView();

        void onRefreshBears();

        void onShowBearDetail(Bear bear);
    }
}
