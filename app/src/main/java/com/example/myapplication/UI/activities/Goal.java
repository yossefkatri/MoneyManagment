package com.example.myapplication.UI.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BE.Label;
import com.example.myapplication.BE.Limit;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        if (v.getId() == R.id.add_goal) {
            addGoal();
        }
    }

    private void addGoal() {
        EditText labelsText = findViewById(R.id.labelsInput);
        EditText limitText = findViewById(R.id.limitInput);
        Limit limit = new Limit();
        List<Label> labels = createLabelsFromInput(String.valueOf(labelsText.getText()));
        try {
            limit.setLimit(Integer.parseInt(String.valueOf(limitText.getText())));
            limit.setLabels(labels);
        } catch (NumberFormatException e) {
            Log.i(this.getClass().toString(), "limit is wrong input ,the input should be number");
            return;
        }
        addLimitToView(limit);
    }

    private void addLimitToView(Limit limit) {
        LinearLayout goals = (LinearLayout) findViewById(R.id.goals);

        TextView labels;
        TextView limit;
        LinearLayout limitLayer = new LinearLayout(this);
        limitLayer.setOrientation(LinearLayout.HORIZONTAL);

        goals.add
    }

    private List<Label> createLabelsFromInput(String labelsRaw) {
        List<Label> labels = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(labelsRaw, ";,");
        while (stringTokenizer.hasMoreTokens()) {
            String labelName = stringTokenizer.nextToken();
            labels.add(new Label(labelName));
        }
        //should update payment from above layer
        return labels;
    }
}