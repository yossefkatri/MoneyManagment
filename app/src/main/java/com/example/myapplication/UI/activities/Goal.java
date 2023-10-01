package com.example.myapplication.UI.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.BE.Label;
import com.example.myapplication.BE.Limit;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Goal extends AppCompatActivity implements View.OnClickListener {

    List<Limit> tempLimits = new ArrayList<>();

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
            labels.sort(Comparator.comparing(Label::getName));
            limit.setLabels(labels);
        } catch (NumberFormatException e) {
            Log.i(this.getClass().toString(), "limit is wrong input ,the input should be number");
            return;
        }
        int index = getIndex(labels);
        if (index < 0) {
            addLimitToView(limit);
            tempLimits.add(limit);
        } else {
            tempLimits.get(index).setLimit(limit.getLimit());
            updateLimitToView(limit);
        }
        Toast.makeText(this,"tempLimits size: "+tempLimits.size(),Toast.LENGTH_LONG).show();
    }

    private void updateLimitToView(Limit limit) {
        //TODO implement the method
    }

    /**
     * @param labels labels input from the user
     * @return the index in the list which this limit is located, otherwise -1
     */
    private int getIndex(List<Label> labels) {
        for (int i = 0; i < tempLimits.size(); ++i) {
            if (tempLimits.get(i).getLabels().equals(labels)) {
                return i;
            }
        }
        return -1;
    }

    private void addLimitToView(Limit limit) {
        LinearLayout goals = findViewById(R.id.goals);

        TextView limitView = new TextView(this);
        limitView.setTextSize(15);
        limitView.setText(createLimitString(limit));
        //TextView limit;
        //LinearLayout limitLayer = new LinearLayout(this);
        //limitLayer.setOrientation(LinearLayout.HORIZONTAL);

        goals.addView(limitView);
        goals.invalidate();
    }

    private String createLimitString(Limit limit) {
        List<Label> labels = limit.getLabels();
        StringBuilder res = new StringBuilder();
        res.append("label: ");
        for (Label label : labels) {
            res.append(label.getName());
            res.append("+");
        }
        res.deleteCharAt(res.length() - 1);
        res.append(" limit: " + limit.getLimit());
        return res.toString();
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