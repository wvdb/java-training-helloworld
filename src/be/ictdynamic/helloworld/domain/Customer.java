package be.ictdynamic.helloworld.domain;

import be.ictdynamic.helloworld.exception.MyCustomizedException;
import be.ictdynamic.helloworld.exception.MyDomainException;
import com.sun.deploy.util.StringUtils;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Customer extends DatabaseEntity {
    private String firstName;
    private String middleName;
    private String lastName;

    public Customer(String firstName, String middleName, String lastName) {
//        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
    }

    public String getFirstName() {
        if (firstName == null) {
            firstName = "";
        }
        return firstName;
    }

    public void setFirstName(String firstName) throws MyCustomizedException {
//        if (firstName != null && firstName.length() == 0) {
//            throw new IllegalArgumentException();
//        }
        if (firstName == null || firstName.length() == 0) {
            throw new MyCustomizedException();
        }
        this.firstName = firstName;
    }

    public String getMiddleName() {
        if (middleName == null) {
            middleName = "";
        }
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        if (lastName == null) {
            lastName = "";
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
