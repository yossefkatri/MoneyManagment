package com.example.myapplication.UI.activities;

import static com.example.myapplication.R.id.add;
import static com.example.myapplication.R.id.date;
import static com.example.myapplication.UI.consts.MainActivityConsts.ADD_BUTTON_TYPE_KEY;
import static com.example.myapplication.UI.utils.DateUtils.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BE.Label;
import com.example.myapplication.BE.Payment;
import com.example.myapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPayment extends AppCompatActivity implements View.OnClickListener {

    private static long id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);
        Button add = findViewById(R.id.add);
        EditText date = findViewById(R.id.date);
        initDate(date, this);
        add.setOnClickListener(this);

    }

    private boolean isExpense() {
        Intent intent = getIntent();
        return intent.getBooleanExtra(ADD_BUTTON_TYPE_KEY, true);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case add:
                createPayment();
                break;
            case date:
                EditText date = findViewById(R.id.date);
                displayDate(this, date);
                break;
        }
    }


    private void createPayment() {

        EditText name = findViewById(R.id.name);
        EditText date = findViewById(R.id.date);
        EditText price = findViewById(R.id.price);
        EditText label = findViewById(R.id.label);

        Payment payment = new Payment();
        payment.setName(String.valueOf(name.getText()));

        String labelName = String.valueOf(label.getText());
        Label labelObject = findOrCreate(labelName, payment);
        payment.addLabel(labelObject);
        SimpleDateFormat format = new SimpleDateFormat(PATTERN);
        Date paymentDate;
        try {
            double priceValue = Double.parseDouble(String.valueOf(price.getText()));
            if (isExpense()) {
                priceValue *= -1;
                Log.d(this.getClass().toString(), "expense is being created");
            } else {
                Log.d(this.getClass().toString(), "income is being created");
            }
            payment.setPrice(priceValue);
            paymentDate = format.parse(String.valueOf(date.getText()));
        } catch (ParseException e) {
            Log.i(this.getClass().toString(), "date is wrong input ,the input should be in format " + PATTERN);
            paymentDate = new Date();
        } catch (NumberFormatException e) {
            Log.i(this.getClass().toString(), "price is wrong input ,the input should be number");
            return;
        }
        payment.setDate(paymentDate);
        payment.setId(id++);
        Log.d(this.getClass().toString(), payment.toString());
        Toast.makeText(this, "Payment has successfully been created", Toast.LENGTH_LONG).show();
    }

    private Label findOrCreate(String labelName, Payment payment) {
        Label label = new Label();
        label.addPayment(payment);
        label.setName(labelName);
        return label;
    }
}