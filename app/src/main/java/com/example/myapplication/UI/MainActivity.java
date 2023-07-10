package com.example.myapplication.UI;

import static com.example.myapplication.UI.consts.mainActivityConsts.ADD_BUTTON_TYPE_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.UI.activities.addPayment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addExpense = findViewById(R.id.add_expense);
        Button addIncome = findViewById(R.id.add_income);
        addExpense.setOnClickListener(this);
        addIncome.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_expense || view.getId() == R.id.add_income) {
            Intent addActivity = new Intent(this, addPayment.class);
            addActivity.putExtra(ADD_BUTTON_TYPE_KEY, view.getId() == R.id.add_expense);
            startActivity(addActivity);
        }
    }
}
