package be.ictdynamic.helloworld.domain;

import java.io.Serializable;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public abstract class Worker implements Serializable{
    private Integer id;
    private String name;
    private Integer age;
    private Sex gender;
    private Float salary;

    public enum Sex {
        MALE, FEMALE, OTHER
    }

    public Worker() {
    }

    public Worker(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void testClassMethod() {
        System.out.println("The static method in Worker");
    }

    public void testInstanceMethod() {
        System.out.println("The instance method in Worker");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    // abstract method - the actual impl will be talen care of by the worker's sub-classes
    public abstract Float calculateSalary(Float... objects);

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;

        Worker worker = (Worker) o;

        return id.equals(worker.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
