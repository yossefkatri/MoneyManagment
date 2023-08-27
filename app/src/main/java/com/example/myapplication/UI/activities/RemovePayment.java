package com.example.myapplication.UI.activities;

import static com.example.myapplication.R.id.remove;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class RemovePayment extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_payment);
        Button add = findViewById(remove);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == remove) {
            removePayment();
        }
    }

    private void removePayment() {
        EditText idView = findViewById(R.id.id);
        try {

            long id = Long.parseLong(String.valueOf(idView.getText()));
            Log.d(this.getClass().toString(), "try to remove payment with id " + id);
            Toast.makeText(this, "payment doesn't exist", Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Log.e(this.getClass().toString(), e.getMessage());
            Toast.makeText(this, "Invalid argument in id field", Toast.LENGTH_LONG).show();
        }
    }
}