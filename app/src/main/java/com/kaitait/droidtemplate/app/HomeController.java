package com.kaitait.droidtemplate.app;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluelinelabs.conductor.Controller;
import com.kaitait.droidtemplate.R;

/**
 * Created by kai on 5/4/17.
 */

public class HomeController extends Controller {

    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home, container, false);
        ((TextView)view.findViewById(R.id.tv_title)).setText("Hello World");
        return view;
    }

}