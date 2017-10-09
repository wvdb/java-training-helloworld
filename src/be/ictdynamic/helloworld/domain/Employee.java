package be.ictdynamic.helloworld.domain;

import be.ictdynamic.helloworld.exception.MyDomainException;

import java.util.Date;
import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Employee extends Worker {
    public final static int MAX_NUMBER_OF_REMUNERATIONS_FOR_EMPLOYEE = 2;
    private static int numberOfEmployees;
    private static int numberOfFemaleEmployees;

//    private Set<Address> addresses;
    private Manager manager;
    private boolean validEmployee = true;

    public Employee(Manager manager, String name, Integer age, Gender gender, Date hireDate) {
        super(name, age, gender, hireDate);
        this.manager = manager;
        numberOfEmployees+= 1;
        if (Gender.FEMALE == gender) {
            numberOfFemaleEmployees += 1;
        }
        if (numberOfEmployees > 5 && (numberOfFemaleEmployees < numberOfEmployees / 2) && Gender.MALE == gender) {
           System.err.println("We are getting too many male employees. Employee " + this + " should be rejected.");
           this.validEmployee = false;
        }
    }

    public Employee() {
        super();
    }

//    Does not compile !!!
//    @Override
    public static void testClassMethod() {
        System.out.println("The static method in Employee");
    }

    @Override
    public void testInstanceMethod() {
        System.out.println("The instance method in Employee");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name=" + getFirstName() +
                ", age=" + getAge() +
                ", remunerations=" + getRemunerations() +
                ", projects=" + getProjects() +
                ", department=" + department +
                '}';
    }

    @Override
    public void setRemunerations(Set<Remuneration> remunerations) {
        if (remunerations.size() <= MAX_NUMBER_OF_REMUNERATIONS_FOR_EMPLOYEE) {
            this.remunerations = remunerations;
        }
        else {
            System.err.println("Employee " + this + " is getting too many remunerations");
            // option 2
            this.validEmployee = false;
        }
    }

    public Employee withHireDate(Date hireDate) {
        super.setHireDate(hireDate);
        return this;
    }

    public Employee withProjects(Set<Project> projects) {
        super.setProjects(projects);
        return this;
    }

    public Employee withSocialSecurityNumber(String socialSecurityNumber) {
        super.setSocialSecurityNumber(socialSecurityNumber);
        return this;
    }


    // DOES COMPILE OR DOES NOT ???
    // a dummyMethod exists as well in Worker
    // verify access level
//    @Override
//    private void dummyMethod() {
//        System.out.println("do something");
//    }

    @Override
    public Float calculateTotalIncentiveCost() {
        float totalIncentiveCost = 0;
//        if (objects == null) {
//            throw new IllegalArgumentException("An Employee should have at least one remuneration.");
//        }
//        if (objects.length > 1) {
//            throw new IllegalArgumentException("An Employee cannot have more than one remuneration.");
//        }

        if (this.getRemunerations() == null || this.getRemunerations().size() == 0) {
            throw new MyDomainException("A worker should have at least one remuneration.", "Employee");
            // NO ADDITIONAL LOGGING
//            throw new MyDomainException2("A worker should have at least one remuneration.", "Employee");
        }

        for (Remuneration remuneration : this.getRemunerations()) {
            if (remuneration instanceof MealVoucher) {
                totalIncentiveCost += remuneration.getCost() * MealVoucher.NUMBER_OF_OCCURRANCES;
            } else {
                totalIncentiveCost += remuneration.getCost() * Remuneration.NUMBER_OF_OCCURRANCES;
            }
        }
        return totalIncentiveCost;
    }

    public final static Float calculateTotalIncentiveCost(Remuneration[] remunerations) {
        float totalIncentiveCost = 0;
        if (remunerations == null || remunerations.length == 0) {
            throw new IllegalArgumentException("An Employee should have at least one remuneration.");
        }
        if (remunerations.length > 2) {
            throw new IllegalArgumentException("An Employee cannot have more than one remuneration.");
        }

        for (Remuneration remuneration : remunerations) {
            if (remuneration instanceof MealVoucher) {
                totalIncentiveCost += remuneration.getCost() * MealVoucher.NUMBER_OF_OCCURRANCES;
            } else {
                totalIncentiveCost += remuneration.getCost() * Remuneration.NUMBER_OF_OCCURRANCES;
            }
        }
        return totalIncentiveCost;
    }

    public boolean isValidEmployee() {
        return validEmployee;
    }

    public class Address extends DatabaseEntity {
        // should be an enum
        private String addressType;
        private String street;
        private String houseNo;
        private String zip;
        private String city;

        public Address(String addressType, String street, String houseNo, String zip, String city) {
            this.addressType = addressType;
            this.street = street;
            this.houseNo = houseNo;
            this.zip = zip;
            this.city = city;
        }

        public String getAddressType() {
            return addressType;
        }

        public void setAddressType(String addressType) {
            this.addressType = addressType;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getHouseNo() {
            return houseNo;
        }

        public void setHouseNo(String houseNo) {
            this.houseNo = houseNo;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", houseNo='" + houseNo + '\'' +
                    ", zip='" + zip + '\'' +
                    ", city='" + city + '\'' +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            // BE AWARE !!!
//            if (!super.equals(o)) return false;

            Address address = (Address) o;

            if (!getAddressType().equals(address.getAddressType())) return false;
            if (!getStreet().equals(address.getStreet())) return false;
            if (!getHouseNo().equals(address.getHouseNo())) return false;
            if (!getZip().equals(address.getZip())) return false;
            return getCity().equals(address.getCity());
        }

        @Override
        public int hashCode() {
            // BE AWARE !!!
//            int result = super.hashCode();
//            result = 31 * result + getAddressType().hashCode();
            int result = 31 * getAddressType().hashCode();
            result = 31 * result + getStreet().hashCode();
            result = 31 * result + getHouseNo().hashCode();
            result = 31 * result + getZip().hashCode();
            result = 31 * result + getCity().hashCode();
            return result;
        }
    }


}
