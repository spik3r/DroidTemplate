package com.kaitait.droidtemplate.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.kaitait.droidtemplate.R;
import com.kaitait.droidtemplate.app.controllers.HomeController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ActionBarProvider {

    @BindView(R.id.controller_containerr)
    ViewGroup container;
    @BindView(R.id.toolbarr)
    Toolbar toolbar;

    private static Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        router = Conductor.attachRouter(this, this.container, savedInstanceState);
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(new HomeController()));
        }
    }

    @Override
    public void onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed();
        }
    }
    
    public Router getRouter() {
        return router;
    }
}
