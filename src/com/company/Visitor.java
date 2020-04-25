package com.company;

import java.text.*;
import java.util.ArrayList;
import java.util.Date;

public class Visitor extends Man implements Runnable, IManType{
    private int Visitor_ID;
    private int RegistrationYear;
    private ArrayList<Book> GivenBooks;
    Book book;
    Thread t;
    boolean suspendedFlag;

    Visitor(String _name, boolean _sex, int _age, int _visitorID, int _RegistrationYear, int _BooksCount)
    {
    Name = _name;
    sex = _sex;
    Age = _age;
    Visitor_ID = _visitorID;
    RegistrationYear = _RegistrationYear;
    GivenBooks = new ArrayList<Book>(_BooksCount);
    }

    Visitor(Book book1) {
        book = book1;
        t = new Thread(this, "Consumer");
    }

    public Visitor() {

    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(Name + " took a book with number: " + i);
                book.get();
                Thread.sleep(300);
                synchronized (this) {
                    while (suspendedFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Name + " stopped work");
        }
        System.out.println(Name + " finished work");
    }

    synchronized void mysuspend() {
        suspendedFlag = true;
    }

    synchronized void myresume() {
        suspendedFlag = false;
        notify();
    }

    public int getRegistrationYear() {
        return RegistrationYear;
    }

    public int getVisitor_ID() {
        return Visitor_ID;
    }

    public void setVisitor_ID(int visitor_ID) {
        Visitor_ID = visitor_ID;
    }

    public void setRegistrationYear(int registrationYear) {
        RegistrationYear = registrationYear;
    }

    public void GetBook(String title)
    {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        GivenBooks.add(new Book(title, formatForDateNow.format(new Date())));
    }

    public void ReturnBook(Book book)
    {
        try
        {
            if (GivenBooks.size() > 0)
                GivenBooks.remove(book);
            else throw new ArithmeticException();
        }
        catch (ArithmeticException ex)
        {
            System.out.println("Visitor don`t have books");
        }
    }

    @Override
    public String getManType() {
        return "Visitor";
    }

    public void GetInformationAboutVisitor()
    {
        super.GetInformationAboutMan();
        System.out.println(getManType());
        System.out.println("ID: " + getVisitor_ID());
        System.out.println("Registration year: " + getRegistrationYear());
        System.out.println("Book count: " + GivenBooks.size());
        System.out.println("");
    }

    public String toString()
    {
        return getManType() + "\t" + Name + "\t" + sex + "\t" + Age + "\t" + Visitor_ID + "\t" + RegistrationYear + "\t" + GivenBooks.size();
    }

    @Override
    public void getRole() {
        System.out.println("Role: Visitor");
    }
}
