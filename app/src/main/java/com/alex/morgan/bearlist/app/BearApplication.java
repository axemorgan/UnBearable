package com.alex.morgan.bearlist.app;

import android.app.Application;

import com.alex.morgan.bearlist.list.BearListComponent;
import com.alex.morgan.bearlist.list.DaggerBearListComponent;

public class BearApplication extends Application {

    private static BearApplication instance;

    public static BearApplication get() {
        return instance;
    }


    private AppComponent appComponent;
    private BearListComponent bearListComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public BearListComponent getBearListComponent() {
        if (bearListComponent == null) {
            this.bearListComponent = DaggerBearListComponent.builder()
                    .appComponent(appComponent).build();
        }
        return bearListComponent;
    }

    public void releaseBearListComponent() {
        this.bearListComponent = null;
    }
}
