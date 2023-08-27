package com.example.myapplication.UI.utils;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static final String PATTERN = "dd/MM/yyyy";
    public static DatePickerDialog datePickerDialog;
    public static SimpleDateFormat format = new SimpleDateFormat(PATTERN);

    @SuppressLint("DefaultLocale")
    public static void initDate(EditText date, View.OnClickListener listener) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        date.setText(String.format("%d/%d/%d", mDay, mMonth + 1, mYear));
        date.setOnClickListener(listener);
    }

    @SuppressLint("DefaultLocale")
    public static void displayDate(Context context, EditText date) {
        int mYear;
        int mMonth;
        int mDay;
        try {
            Calendar calendar = Calendar.getInstance();
            Date currentDate = format.parse(String.valueOf(date.getText()));
            calendar.setTime(currentDate);
            mYear = calendar.get(Calendar.YEAR);
            mMonth = calendar.get(Calendar.MONTH);
            mDay = calendar.get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR); // current year
            mMonth = c.get(Calendar.MONTH); // current month
            mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        }
        // date picker dialog
        datePickerDialog = new DatePickerDialog(context,
                (view, year, monthOfYear, dayOfMonth) -> {
                    // set day of month , month and year value in the edit text
                    date.setText(String.format("%d/%d/%d", dayOfMonth, monthOfYear + 1, year));

                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

}
