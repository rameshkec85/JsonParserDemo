package com.companyname.jsonparserdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ramesh on 09/02/19.
 */

public class SplashscreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                moveToNext();
            }
        }, 2000);
    }

    private void moveToNext() {
        startActivity(new Intent(this, DemoActivity.class));
        finish();
    }


}
