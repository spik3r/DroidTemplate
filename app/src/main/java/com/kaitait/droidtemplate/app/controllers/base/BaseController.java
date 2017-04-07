package com.kaitait.droidtemplate.app.controllers.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.rxlifecycle2.RxController;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;


public abstract class BaseController extends RxController {
    private CompositeDisposable composite_disposable = new CompositeDisposable();
    private Unbinder unbinder;

    public BaseController(Bundle args)
    {
        super(args);
    }

    protected abstract View inflateView(
            @NonNull LayoutInflater inflater,
            @NonNull ViewGroup container);

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container)
    {
        View view = inflateView(inflater, container);
        unbinder = ButterKnife.bind(this, view);
        OnViewButterknifeBound(view, inflater);
        return view;
    }

    @Override
    protected void onDestroyView(@NonNull View view)
    {
        super.onDestroyView(view);
        unbinder.unbind();
        unbinder = null;
    }

    @Override
    protected void onDestroy()
    {
        this.composite_disposable.clear();
        super.onDestroy();
    }

    protected void OnViewButterknifeBound(@NonNull View view, LayoutInflater inflater) { }

    public void RegisterObserverForDisposal(Observable observable, DisposableObserver observer)
    {
        this.composite_disposable.add((Disposable) observable.subscribeWith(observer));
    }
}
