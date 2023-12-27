package com.example.ecommerceapp.Activity ;

import androidx.appcompat.app.AppCompatActivity ;
import android.os.Bundle ;
import com.example.ecommerceapp.R ;
import android.content.Intent;
import android.widget.*;
public class IntroActivity extends AppCompatActivity {

    private Button BtnStart ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introactivity);

        BtnStart = findViewById(R.id.introBtn);
        BtnStart.setOnClickListener(V -> startActivity(new Intent(IntroActivity.this, main_activity.class)));
    }};