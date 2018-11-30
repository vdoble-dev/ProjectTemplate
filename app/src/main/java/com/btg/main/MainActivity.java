package com.btg.main;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import com.btg.R;
import com.btg.root.App;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    @Inject
    MainContract.Presenter presenter;

    @BindView(R.id.main_text)
    TextView mainTextView;

    @BindView(R.id.main_floating_button)
    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplicationContext()).getComponent().inject(this);
        ButterKnife.bind(this);
        presenter.setView(this);
    }

    @OnClick(R.id.main_floating_button)
    public void buttonOnClick(View view) {
        presenter.showMainText();
    }

    @Override
    public void onLoadMainText(String text) {
        mainTextView.setText(text);
    }
}
