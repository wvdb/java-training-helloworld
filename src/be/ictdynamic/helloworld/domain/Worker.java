package be.ictdynamic.helloworld.domain;

import java.io.Serializable;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Worker implements Serializable{
    private Integer id;
    private String name;
    private Integer age;

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
