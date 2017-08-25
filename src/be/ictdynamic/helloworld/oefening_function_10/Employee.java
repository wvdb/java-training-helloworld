package be.ictdynamic.helloworld.oefening_function_10;

import java.io.Serializable;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Employee implements Serializable{
    private String name;
    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
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
}
