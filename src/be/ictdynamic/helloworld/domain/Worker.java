package be.ictdynamic.helloworld.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public abstract class Worker extends DatabaseEntity {
    static public boolean isEligibleForRemuneration = Boolean.TRUE;

    private String name;
    private Integer age;
    private Gender gender;
    private Date hireDate;
    protected Department department;
    private Project[] projects;
    protected Remuneration[] remunerations;

    public Worker() {
    }

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public Worker(String name, Integer age, Gender gender, Date hireDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public static void testClassMethod() {
        System.out.println("The static method in Worker");
    }

    public void testInstanceMethod() {
        System.out.println("The instance method in Worker");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // abstract method - the actual impl will be taken care of by the worker's sub-classes
    public abstract Object calculateSalary(Object... objects);

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Project[] getProjects() {
        if (projects == null) {
            projects = new Project[5];
        }
        return projects;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }

    public Remuneration[] getRemunerations() {
        if (remunerations == null) {
            remunerations = new Remuneration[4];
        }
        return remunerations;
    }

    protected abstract void setRemunerations(Remuneration[] remunerations);

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

}
