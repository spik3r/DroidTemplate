package com.kaitait.droidtemplate.app.controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaitait.droidtemplate.R;
import com.kaitait.droidtemplate.app.controllers.base.BaseController;
import com.kaitait.droidtemplate.app.util.DisposableUIObserver;
import com.kaitait.droidtemplate.app.viewmodels.OtherViewModel;
import com.kaitait.droidtemplate.databinding.ControllerOtherBinding;

public class OtherController extends BaseController {

    OtherViewModel otherViewModel;
    ControllerOtherBinding binding;
    
    public OtherController(Bundle args) {
        super(args);
    }

    public OtherController()
    {
        this(null);
    }

    @Override
    protected void OnViewButterknifeBound(@NonNull View view, LayoutInflater inflater)
    {
        super.OnViewButterknifeBound(view, inflater);
        this.binding = ControllerOtherBinding.bind(view);
        this.otherViewModel = new OtherViewModel("The other controller");
        binding.setViewModel(this.otherViewModel);
        SetObservers();
    }
    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.controller_other, container, false);
    }

    private void SetObservers()
    {
        this.RegisterObserverForDisposal(
                binding.getViewModel().back_click,
                LaunchBackController());
        
    }

    @NonNull
    private DisposableUIObserver LaunchBackController()
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

    public void onButtonClicked() {
        getRouter().popToRoot();
    }
}
