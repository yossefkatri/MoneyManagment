package com.example.myapplication.BE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return name.equals(label.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
