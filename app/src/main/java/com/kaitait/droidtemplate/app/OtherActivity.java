package com.kaitait.droidtemplate.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kaitait.droidtemplate.R;

/**
 * Created by kai-tait on 18/04/2017.
 */

public class OtherActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        setContentView(R.layout.activity_other);
    }
}
