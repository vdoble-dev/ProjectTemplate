package com.btg.root;

import com.btg.api.ApiModule;
import com.btg.main.MainActivity;
import com.btg.main.MainModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
                ApplicationModule.class,
                ApiModule.class,
                MainModule.class,})
public interface ApplicationComponent {
    void inject(MainActivity target);
}
