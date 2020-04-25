package com.company;

abstract class Employee extends Man implements IWorkStarted{
    public int EmployeeId;
    public int Experience;
    public int Salary;
    public String Education;

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getExperience()
    {
        return Experience;
    }

    public void GetInformationAboutEmployee()
    {
        super.GetInformationAboutMan();
        System.out.println("Experience: " + getExperience());
        System.out.println("Salary: " + getSalary());
        System.out.println("Education: " + getEducation());
    }

    public int getSalary()
    {
        return Salary;
    }

    public String getEducation()
    {
        return Education;
    }

    public void setSalary(int _salary)
    {
        Salary = _salary;
    }

    public void setEducation(String _education)
    {
        Education = _education;
    }

    public void setExperience(int _experience)
    {
        Experience = _experience;
    }

    @Override
    public String getManType()
    {
        return "Employee";
    }

    public String getWork()
    {
        return "Work is undefined";
    }

    public abstract String toString();
}
