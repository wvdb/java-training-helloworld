package be.ictdynamic.helloworld.domain;

import be.ictdynamic.helloworld.enums.AddressType;
import be.ictdynamic.helloworld.enums.Country;
import be.ictdynamic.helloworld.exception.MyDomainException;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Employee extends Worker {
    public final static int MAX_NUMBER_OF_REMUNERATIONS_FOR_EMPLOYEE = 12;
    private static int numberOfEmployees;
    private static int numberOfFemaleEmployees;

    private Map<AddressType, Address> addresses;
    private Manager manager;
    private Address address;
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

        this.address = this.new Address("street 1", "house no 1", "zip 1", "commune 1");

    }

    public Employee() {
        super();
    }

    // Does not compile !!!
    // @Override
    // the old static method is just hidden, not overridden!!!
    public static void myDummyStaticMethod() {
    }

    // Does not compile !!!
    // @Override
    // the old static method is just hidden, not overridden!!!
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
//                ", accienityInYears=" + getAccienityInYears() +
                ", accienityInYears2=" + accienityInYears2 +
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

    public Employee withCountry(Country country) {
        super.setCountry(country);
        return this;
    }

    public Employee withSocialSecurityNumber(String socialSecurityNumber) {
        super.setSocialSecurityNumber(socialSecurityNumber);
        return this;
    }

//    @Override
    private String getFullName(String... partOfNames) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mr/Mrs ");
        for (String partOfName : partOfNames) {
            stringBuilder.append(partOfName);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
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
        private String street;
        private String houseNo;
        private String zip;
        private String city;

        public Address() {
        }

        public Address(String street, String houseNo, String zip, String city) {
            this.street = street;
            this.houseNo = houseNo;
            // to invoke the setter of ZIP
            this.setZip(zip);
            this.city = city;
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
            if (Employee.this.getCountry() != null && zip != null) {
                // TODO : to exaplain syntax of OuterClass.this
                if (   Employee.this.getCountry() == Country.BELGIUM && zip.length() != 4
                    || Employee.this.getCountry() == Country.NETHERLANDS && zip.length() != 6) {
                    System.err.println("ZIP code has an invalid length. Expected length = "
                            + (Employee.this.getCountry() == Country.BELGIUM ? 4 : 6));
                }
            }
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
            if (this == o) {
                return true;
            }
            if (!(o instanceof Address)) {
                return false;
            }
            if (!super.equals(o)) {
                return false;
            }

            Address address = (Address) o;

            if (!city.equals(address.city)) {
                return false;
            }
            if (!houseNo.equals(address.houseNo)) {
                return false;
            }
            if (!street.equals(address.street)) {
                return false;
            }
            if (!zip.equals(address.zip)) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + street.hashCode();
            result = 31 * result + houseNo.hashCode();
            result = 31 * result + zip.hashCode();
            result = 31 * result + city.hashCode();
            return result;
        }
    }


}
