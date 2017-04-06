package com.kaitait.droidtemplate.app.viewmodels;

import android.databinding.BaseObservable;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by kai-tait on 6/04/2017.
 */

public class HomeViewModel extends BaseObservable {
    public PublishSubject<Object> next_click;


    public HomeViewModel() {
        InitialiseClickObservables();
    }

    private void InitialiseClickObservables()
    {
        this.next_click = PublishSubject.create();
    }
}
