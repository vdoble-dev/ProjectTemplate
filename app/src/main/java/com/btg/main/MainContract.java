package com.btg.main;

public interface MainContract {
    interface View {
        void onLoadMainText(String text);
    }
    interface Presenter {
        void setView(MainContract.View view);
        void showMainText();
    }
    interface Repository {
        String fetchMainText();
    }
}
