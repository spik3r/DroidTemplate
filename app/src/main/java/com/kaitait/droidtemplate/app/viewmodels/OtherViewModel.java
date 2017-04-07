package com.kaitait.droidtemplate.app.viewmodels;

import android.databinding.ObservableField;

import io.reactivex.subjects.PublishSubject;

public class OtherViewModel {
    public ObservableField<String> title = new ObservableField<>();
    public PublishSubject<Object> back_click;

    public OtherViewModel(String title) {
        this.back_click = PublishSubject.create();
        this.title.set(title);
    }
}
