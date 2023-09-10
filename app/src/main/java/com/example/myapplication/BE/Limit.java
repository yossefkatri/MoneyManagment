package com.example.myapplication.BE;

import java.util.List;

public class Limit {
    List<Label> labels;
    int limit;

    public void addLabel(Label label) {
        labels.add(label);
    }

    public void removeLabel(Label label) {
        labels.remove(label);
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
