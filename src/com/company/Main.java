package com.company;

public class Main {

    public static void main(String[] args) {
        String manRole = "Visitor";
        Factory factory = new Factory();
        Man man = factory.getCurrentMan(manRole);
        man.getRole();
    }
}