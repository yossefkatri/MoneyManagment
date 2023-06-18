package com.example.myapplication.UI.activities;

import static com.example.myapplication.R.id.add;
import static com.example.myapplication.R.id.date;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BI.Expense;
import com.example.myapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class addExpenses extends AppCompatActivity implements View.OnClickListener {

    public static final String PATTERN = "dd/MM/yyyy";
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenses);
        Button add = findViewById(R.id.add);
        EditText date = findViewById(R.id.date);
        initDate(date);
        add.setOnClickListener(this);

    }


    @SuppressLint("DefaultLocale")
    private void initDate(EditText date) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        date.setText(String.format("%d/%d/%d", mDay, mMonth + 1, mYear));
        date.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case add:
                addExpense();
                break;
            case date:
                displayDate();
                break;
        }
    }

    @SuppressLint("DefaultLocale")
    private void displayDate() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        EditText date = findViewById(R.id.date);
        // date picker dialog
        datePickerDialog = new DatePickerDialog(this,
                (view, year, monthOfYear, dayOfMonth) -> {
                    // set day of month , month and year value in the edit text
                    date.setText(String.format("%d/%d/%d", dayOfMonth, monthOfYear + 1, year));

                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


    private void addExpense() {
        EditText name = findViewById(R.id.name);
        EditText date = findViewById(R.id.date);
        EditText price = findViewById(R.id.price);
        EditText label = findViewById(R.id.label);

        Expense expense = new Expense();
        expense.setName(String.valueOf(name.getText()));
        expense.setLabel(String.valueOf(label.getText()));
        expense.setPrice(Integer.parseInt(String.valueOf(price.getText())));

        SimpleDateFormat format = new SimpleDateFormat(PATTERN);
        Date expenseDate;
        try {
            expenseDate = format.parse(String.valueOf(date.getText()));
        } catch (ParseException e) {
            Log.i(this.getClass().toString(), "date is wrong input ,the input should be in format " + PATTERN);
            expenseDate = new Date();
        }
        expense.setDate(expenseDate);
        Log.d(this.getClass().toString(),expense.toString());
        Toast.makeText(this,"Object has successfully been created",Toast.LENGTH_LONG).show();
    }
}