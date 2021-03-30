package com.snail.activityforresultexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.snail.activityforresult.ActivityForResultUtil;
import com.snail.activityforresult.OnActivityResultListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityForResultUtil.startActivityForResult(this, new Intent(this, SecondActivity.class), new OnActivityResultListener() {
            @Override
            public void onActivityResult(int code, int resultCode, Intent data) {
                Log.v("result" ,"" +code + ""+resultCode);
            }
        });
    }


}