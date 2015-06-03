package com.dreamer.practice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dreamer.practice.ActivitiesManager;


/**
 * Created by dreamer on 2015/5/18.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitiesManager.getActivitiesManager().addActivity(this);
    }

    public void showShortToast(String message){
        Toast.makeText(BaseActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String message){
        Toast.makeText(BaseActivity.this,message,Toast.LENGTH_LONG).show();
    }


}
