package com.company;

public class Factory {
    public Man getCurrentMan(String inputMan)
    {
        Man man = null;
        if (inputMan.equals("Visitor"))
        {
            man = new Visitor();
        }
        else if (inputMan.equals("Librarian"))
        {
            man = new Librarian();
        }
        else if (inputMan.equals("Cleaner"))
        {
            man = new Cleaner();
        }
        return man;
    }
}
