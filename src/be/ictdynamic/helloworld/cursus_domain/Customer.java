package be.ictdynamic.helloworld.cursus_domain;

import be.ictdynamic.helloworld.enums.MonthEnumeration;
import be.ictdynamic.helloworld.exception.MyCustomizedException;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Customer {
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected MonthEnumeration monthOfCustomer = MonthEnumeration.DECEMBER;

    public Customer(Integer id, String firstName, String middleName, String lastName)  {
//        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
    }

    public Customer() {
        Customer customer1 = new CustomerBis();
        customer1.setLastName("voorbeeld van een hidden method");

        CustomerBis customer2 = new CustomerBis();
        customer2.setLastName("voorbeeld van een hidden method");
    }

    protected int dummy() {
        return 0;
    }

    public String getFirstName() {
        if (firstName == null) {
            firstName = "";
        }
        return firstName;
    }

    public void setFirstName(String firstName) throws MyCustomizedException {
        if (firstName == null || firstName.length() == 0) {
            throw new MyCustomizedException();
        }
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

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", monthOfCustomer=" + monthOfCustomer +
                '}';
    }
}
