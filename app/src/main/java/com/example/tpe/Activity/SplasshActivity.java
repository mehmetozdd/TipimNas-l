package com.example.tpe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.tpe.R;

public class SplasshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splassh);
        getSupportActionBar().hide();
        splash();
    }

    public void splash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplasshActivity.this, StartActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}