package com.company;

import java.text.*;
import java.util.*;

public class Book {
    String Title;
    int n;
    Date GivingDate;
    boolean valueSet = false;

    Book(String _title, String _date)
    {
        Title = _title;
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        try {
            GivingDate = ft.parse(_date);
        }
        catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    synchronized int get() {
        while (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception caught");
            }
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception caught");
            }
        this.n = n;
        valueSet =true;
        notify();
    }
}
