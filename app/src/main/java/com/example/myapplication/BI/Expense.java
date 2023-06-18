package com.example.myapplication.BI;

import java.util.Date;

public class Expense {
    String name;
    Date date;
    String label;
    Number price;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", label='" + label + '\'' +
                ", price=" + price +
                '}';
    }
}
