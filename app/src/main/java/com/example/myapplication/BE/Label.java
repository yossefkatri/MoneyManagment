package com.example.myapplication.BE;

import java.util.ArrayList;
import java.util.List;

public class Label {
    String name;
    List<Payment> payments;

    public Label() {
        payments = new ArrayList<>();
    }

    public Label(String name) {
        this.name = name;
        payments = new ArrayList<>();
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public void removePayment(Payment payment) {
        payments.remove(payment);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
