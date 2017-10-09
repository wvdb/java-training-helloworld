package be.ictdynamic.helloworld.domain;

import be.ictdynamic.helloworld.exception.MyDomainException;

import java.util.Date;
import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Manager extends Worker {
    public final static int MAX_NUMBER_OF_REMUNERATIONS_FOR_MANAGER = 3;

    private Set<Employee> subordinates;

    public Manager(String name, Integer age, Gender gender, Date hireDate) {
        super(name, age, gender, hireDate);
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public void setRemunerations(Set<Remuneration> remunerations) {
        if (remunerations.size() < MAX_NUMBER_OF_REMUNERATIONS_FOR_MANAGER) {
            this.remunerations = remunerations;
        }
        else {
            System.err.println("This manager is getting too many remunerations");
        }
    }

    @Override
    public Float calculateTotalIncentiveCost() {
        float totalIncentiveCost = 0;

        for (Remuneration remuneration : this.getRemunerations()) {
            if (remuneration instanceof MealVoucher) {
                totalIncentiveCost += remuneration.getCost() * MealVoucher.NUMBER_OF_OCCURRANCES;
            } else {
                totalIncentiveCost += remuneration.getCost() * Remuneration.NUMBER_OF_OCCURRANCES;
            }
        }
        return totalIncentiveCost;
    }

}
