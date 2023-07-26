package com.example.myapplication.UI;

import static com.example.myapplication.UI.consts.MainActivityConsts.ADD_BUTTON_TYPE_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.UI.activities.AddPayment;
import com.example.myapplication.UI.activities.UpdatePayment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addExpense = findViewById(R.id.add_expense);
        Button addIncome = findViewById(R.id.add_income);
        Button updateIncome = findViewById(R.id.update_income);
        Button updateExpense = findViewById(R.id.update_expense);

        addExpense.setOnClickListener(this);
        addIncome.setOnClickListener(this);
        updateIncome.setOnClickListener(this);
        updateExpense.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_expense || view.getId() == R.id.add_income) {
            Intent addActivity = new Intent(this, AddPayment.class);
            addActivity.putExtra(ADD_BUTTON_TYPE_KEY, view.getId() == R.id.add_expense);
            startActivity(addActivity);
        } else if (view.getId() == R.id.update_expense || view.getId() == R.id.update_income) {
            Intent addActivity = new Intent(this, UpdatePayment.class);
            startActivity(addActivity);
        }
    }
}
