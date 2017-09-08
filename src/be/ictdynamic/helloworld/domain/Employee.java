package be.ictdynamic.helloworld.domain;

import java.util.Date;
import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Employee extends Worker {
    // every sub-class of worker has a hireDate, a worker doesn't
    private Date hireDate;
    private Set<Project> projects;
    private Set<Department> department;

    public Employee(Integer id, String name, Integer age, Gender gender, Date hireDate) {
        super(id, name, age, gender);
        this.hireDate = hireDate;
    }

    public Employee() {
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    //    @Override
    public static void testClassMethod() {
        System.out.println("The static method in Employee");
    }

    @Override
    public void testInstanceMethod() {
        System.out.println("The instance method in Employee");
    }

    @Override
    public Float calculateSalary(Float... objects) {
        if (objects == null) {
            throw new IllegalArgumentException("An Employee should have at least one remuneration.");
        }
        if (objects.length > 1) {
            throw new IllegalArgumentException("An Employee cannot have more than one remuneration.");
        }
        return objects[0];
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", age=" + getAge() +
                ", hireDate=" + hireDate +
                ", projects=" + projects +
                ", department=" + department +
                '}';
    }
}
