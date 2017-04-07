package com.kaitait.droidtemplate.app.controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.kaitait.droidtemplate.R;
import com.kaitait.droidtemplate.app.controllers.base.BaseController;
import com.kaitait.droidtemplate.app.util.DisposableUIObserver;
import com.kaitait.droidtemplate.app.viewmodels.HomeViewModel;
import com.kaitait.droidtemplate.databinding.ControllerHomeBinding;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class HomeController extends BaseController {

    private HomeViewModel homeViewModel;
    private ControllerHomeBinding binding;

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
        this.binding = ControllerHomeBinding.bind(view);
        this.homeViewModel = new HomeViewModel("Home Controller", "");
        binding.setViewModel(this.homeViewModel);
        SetObservers();
    }

    @NonNull
    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.controller_home, container, false);
    }

    public void onButtonClicked() {
        getRouter().pushController(RouterTransaction.with(new OtherController())
                .pushChangeHandler(new FadeChangeHandler())
                .popChangeHandler(new FadeChangeHandler()));
    }

    private void SetObservers()
    {
        this.RegisterObserverForDisposal(
                binding.getViewModel().next_click,
                LaunchNextController());


    }

    @NonNull
    private DisposableUIObserver LaunchNextController()
    {
        return new DisposableUIObserver()
        {
            @Override
            public void onNext(Object edit_click)
            {
                        onButtonClicked();
            }
        };
    }

    public void RegisterObserverForDisposal(Observable observable, DisposableObserver observer) {
        CompositeDisposable composite_disposable = new CompositeDisposable();
        composite_disposable.add((Disposable) observable.subscribeWith(observer));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}