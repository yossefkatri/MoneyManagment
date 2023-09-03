package com.example.myapplication.UI.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class Goal extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        Button add = findViewById(R.id.add_goal);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}