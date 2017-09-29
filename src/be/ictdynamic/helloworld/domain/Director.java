package be.ictdynamic.helloworld.domain;

import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Director extends Worker {
    public final static int MAX_NUMBER_OF_REMUNERATIONS_FOR_DIRECTOR = 4;

    public Director(String name, Integer age, Gender gender, Date hireDate) {
        super(name, age, gender, hireDate);
    }

    @Override
    public void setRemunerations(Remuneration[] remunerations) {
        if (remunerations.length < MAX_NUMBER_OF_REMUNERATIONS_FOR_DIRECTOR) {
            this.remunerations = remunerations;
        }
        else {
            System.err.println("This director is getting too many remunerations");
        }
    }

}
