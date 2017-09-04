package be.ictdynamic.helloworld.domain;

import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Director extends Worker {
    // every sub-class of worker has a hireDate, a worker doesn't
    private Date hireDate;

    public Director(String name, Integer age) {
        super(name, age);
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public Float calculateSalary(Float... objects) {
        return null;
    }
}
