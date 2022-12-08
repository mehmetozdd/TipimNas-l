package com.example.tpe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tpe.MainActivity;
import com.example.tpe.R;
import com.example.tpe.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {
    ActivityStartBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
            }
        });



    }
}