package com.btg.main;

import com.btg.api.ExternalAPI;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    public MainContract.Presenter providePresenter(MainContract.Repository repo){
        return new MainPresenter(repo);
    }

    @Provides
    public MainContract.Repository provideRepository(ExternalAPI externalAPI){
        return new RepositoryImpl(externalAPI);
    }

}
