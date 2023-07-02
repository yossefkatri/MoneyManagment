package com.example.myapplication.BI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Expense {
    String name;
    Date date;
    List<String> labels;
    Number price;

    public Expense() {
        labels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public void addLabel(String label) {
        labels.add(label);
    }

    public void removeLabel(String label) {
        labels.remove(label);
    }

    public List<String> getLabels() {
        return labels;
    }

}
