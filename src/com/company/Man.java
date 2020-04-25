package com.company;

import java.util.*;

abstract class Man
{
 public String Name;
 public boolean sex;
 public int Age;

 public Man()
 {

 }

 public void GetInformationAboutMan()
 {
     String sexTitle;
     if (sex)
         sexTitle = "Male";
     else sexTitle = "Female";
     System.out.println("Name: " + getName());
     System.out.println("Age: " + getAge());
     System.out.println("Sex: " + sexTitle);
 }

 public void setAge(int _Age)
 {
     if (_Age < 110)
     {
         Age = _Age;
     }
 }

 public int getAge()
 {
     return Age;
 }

 public String getName() {
     return Name;
 }

 public boolean getSex() {
     return sex;
 }

 public String getManType() {
     return "Type is undefined";
 }

public abstract String toString();

    public abstract void getRole();
}
