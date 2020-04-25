package com.company;

public class Librarian extends Employee implements Runnable, IManType{

    public String Department;
    public String Qualification;
    public int ForeignLanguagesCount;
    Book b;

    Thread t;
    boolean suspendedFlag;

    Librarian(Book b) {
        this.b = b;
        t = new Thread(this, "Producer");
    }

    public Librarian(String _name, boolean _sex, int _age, int _EmployeeId, int _Experience, int _Salary, String _Education, String _Department, String _Qualification, int _ForeignLanguagesCount)
    {
        Name = _name;
        sex = _sex;
        Age = _age;
        EmployeeId = _EmployeeId;
        Experience = _Experience;
        Salary = _Salary;
        Education = _Education;
        Department = _Department;
        Qualification = _Qualification;
        ForeignLanguagesCount = _ForeignLanguagesCount;
    }

    public Librarian() {

    }

    @Override
    public void run() {
        try {
                for (int i = 15; i > 0; i--) {
                    System.out.println(Name + " gave a book with number: " + i);
                    b.put(i);
                    Thread.sleep(200);
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

    @Override
    public String getManType() {
        return "Librarian";
    }

    public void WorkStarted()
    {
        if (getSex())
        {
            System.out.println("He gives books to people");
        }
        else System.out.println("She gives books to people");
    }

    public String getDepartment() {
        return Department;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public int getForeignLanguagesCount() {
        return ForeignLanguagesCount;
    }

    public void setForeignLanguagesCount(int foreignLanguagesCount) {
        ForeignLanguagesCount = foreignLanguagesCount;
    }

    public void getInformationAboutLibrarian()
    {
        super.GetInformationAboutEmployee();
        System.out.println("Type: " + getWork());
        System.out.println("Department: " + getDepartment());
        System.out.println("Qualification: " + getQualification());
        System.out.println("Foreign Languages count: " + getForeignLanguagesCount());
        System.out.println();
    }

    public String toString() {
        return getWork() + "\t" + Name + "\t" + sex + "\t" + Age + "\t" + EmployeeId + "\t" + Experience + "\t" + Salary + "\t" + Education + "\t" + Department + "\t" + Qualification + "\t" + ForeignLanguagesCount;
    }

    @Override
    public void getRole() {
        System.out.println("Role: Librarian");
    }
}
