package com.example.myapplication.BE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Payment {
    long id;
    String name;
    Date date;
    final List<Label> labels;
    double price;

    public Payment() {
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

    public void addLabel(Label label) {
        labels.add(label);
    }

    public void removeLabel(Label label) {
        labels.remove(label);
    }

    public List<Label> getLabels() {
        return labels;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
