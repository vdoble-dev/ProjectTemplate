package com.btg.main;

import android.support.annotation.Nullable;


public class MainPresenter implements MainContract.Presenter {

    @Nullable
    MainContract.View view;

    private final MainContract.Repository repo;

    public MainPresenter(MainContract.Repository repo) {
        this.repo = repo;
    }

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void showMainText() {
        String mainText = repo.fetchMainText();
        view.onLoadMainText(mainText);
    }
}
