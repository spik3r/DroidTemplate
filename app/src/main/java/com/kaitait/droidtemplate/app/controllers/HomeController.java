package com.kaitait.droidtemplate.app.controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.kaitait.droidtemplate.R;
import com.kaitait.droidtemplate.app.controllers.base.BaseController;
import com.kaitait.droidtemplate.app.util.DisposableUIObserver;
import com.kaitait.droidtemplate.app.viewmodels.HomeViewModel;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by kai on 5/4/17.
 */

public class HomeController extends BaseController {

    private DisposableObserver observerButtonObserver;
    private HomeViewModel homeViewModel;
    private HomeController_ViewBinding binding;

    @BindView(R.id.next_button) Button nextButton;

    public HomeController()
    {
        this(null);
    }

    public HomeController(Bundle args) {
        super(args);
    }

    @Override
    protected void OnViewButterknifeBound(@NonNull View view, LayoutInflater inflater)
    {
        super.OnViewButterknifeBound(view, inflater);
        this.homeViewModel = new HomeViewModel();
        this.nextButton.setEnabled(true);
        setObserverButtonObserver();
    }

    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home, container, false);
        ((TextView)view.findViewById(R.id.tv_title)).setText("Hello World");

        return view;
    }

    @NonNull
    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.controller_home, container, false);
    }

    public void onButtonClicked() {
        System.out.println("onButtonClicked");
        getRouter().pushController(RouterTransaction.with(new NavigationDemoController(1, NavigationDemoController.DisplayUpMode.SHOW_FOR_CHILDREN_ONLY))
                .pushChangeHandler(new FadeChangeHandler())
                .popChangeHandler(new FadeChangeHandler())
                .tag(NavigationDemoController.TAG_UP_TRANSACTION));
    }


    public void setObserverButtonObserver() {
        observerButtonObserver = new DisposableObserver() {
            @Override
            public void onNext(Object o) {
                try {
                    Log.i("next", "setObserverButtonObserver");
                    onButtonClicked();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("____ some error happened: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("____ completed");
            }
        };
        SetObserverForNextClick();
    }

    private void SetObserverForNextClick() {
        Log.i("","SetObserverForNextClick");
        this.RegisterObserverForDisposal(
                this.homeViewModel.next_click,
                new DisposableUIObserver<Boolean>() {
                    @Override
                    public void onNext(Boolean login_clicked_form_valid) {
                        Log.i("onNext", "button clicked 133");
                        System.out.println("button clicked");
                        onButtonClicked();
                    }
                });
    }

    public void RegisterObserverForDisposal(Observable observable, DisposableObserver observer) {
        CompositeDisposable composite_disposable = new CompositeDisposable();
        composite_disposable.add((Disposable) observable.subscribeWith(observer));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        observerButtonObserver.dispose();
    }
}