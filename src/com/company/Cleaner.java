package com.company;

public class Cleaner extends Employee implements IManType{
    public int CleaningArea;
    public String EquipmentType;
    public String CleaningQualification;

    public Cleaner() {

    }

    @Override
    public void WorkStarted()
    {
        if (getSex())
        {
            System.out.println("He washes the floor in library");
        }
        else System.out.println("She washes the floor in the reading room");
    }

    public Cleaner(String _name, boolean _sex, int _age, int _EmployeeId, int _Experience, int _Salary, String _Education, int _CleaningArea, String _EquipmentType, String _CleaningQualification)
    {
        Name = _name;
        sex = _sex;
        Age = _age;
        EmployeeId = _EmployeeId;
        Experience = _Experience;
        Salary = _Salary;
        Education = _Education;
        CleaningArea = _CleaningArea;
        EquipmentType = _EquipmentType;
        CleaningQualification = _CleaningQualification;
    }

    public int getCleaningArea() {
        return CleaningArea;
    }

    public String getEquipmentType() {
        return EquipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        EquipmentType = equipmentType;
    }

    public void setCleaningArea(int cleaningArea) {
        CleaningArea = cleaningArea;
    }

    @Override
    public String getManType() {
        return "Cleaner";
    }

    public String getCleaningQualification() {
        return CleaningQualification;
    }

    public void setCleaningQualification(String cleaningQualification) {
        CleaningQualification = cleaningQualification;
    }

    public void GetInformationAboutCleaner()
    {
        super.GetInformationAboutEmployee();
        System.out.println("Type: " + getWork());
        System.out.println("Equipment: " + getEquipmentType());
        System.out.println("Cleaning area: " + getCleaningArea() + " square meters");
        System.out.println("Cleaning qualification: " + getCleaningQualification());
        System.out.println();
    }
    public String toString()
    {
        return getWork() + "\t" + Name + "\t" + sex + "\t" + Age + "\t" + EmployeeId + "\t" + Experience + "\t" + Salary + "\t" + Education + "\t" + CleaningArea + "\t" + EquipmentType + "\t" + CleaningQualification;
    }

    @Override
    public void getRole() {
        System.out.println("Role: Cleaner");
    }
}
