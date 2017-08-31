package be.ictdynamic.helloworld.domain;

import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Manager extends Worker {
    private Set<Employee> subordinates;

    public Manager(String name, Integer age) {
        super(name, age);
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }
}
