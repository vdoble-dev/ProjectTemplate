package com.btg.root;

import android.app.Application;

import com.btg.api.ApiModule;
import com.btg.main.MainModule;


public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule(this))
                .mainModule(new MainModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
