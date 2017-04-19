package com.kaitait.droidtemplate.app.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import io.reactivex.subjects.PublishSubject;

public class HomeViewModel extends BaseObservable {
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> dateTimeTextView = new ObservableField<>();
    public ObservableField<String> text_field = new ObservableField<>();
    public PublishSubject<Object> next_click;
    public PublishSubject<Object> intent_click;

    public HomeViewModel(String title, String textField) {
        this.next_click = PublishSubject.create();
        this.intent_click = PublishSubject.create();
        this.title.set(title);
        this.text_field.set(textField);
        this.dateTimeTextView.set("default");
    }

    @Bindable
    public String getTextField() {
        return this.text_field.get();
    }
}
