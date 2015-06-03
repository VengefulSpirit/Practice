package com.dreamer.practice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.dreamer.practice.R;


/**
 * Created by dreamer on 2015/5/29.
 */
public class SplashActivity extends BaseActivity {
    int SPLASH_TIME=1000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
                //overridePendingTransition(0,android.R.anim.fade_out);
            }
        },SPLASH_TIME);
    }
}
