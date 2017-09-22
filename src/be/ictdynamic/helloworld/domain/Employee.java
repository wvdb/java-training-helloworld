package be.ictdynamic.helloworld.domain;

import be.ictdynamic.helloworld.exception.MyDomainException;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Employee extends Worker {
    // every sub-class of worker has a hireDate, a worker doesn't
    private Date hireDate;
    private Set<Project> projects;
    private Set<Department> departments;
    private Set<Address> addresses;

    public Employee(Integer id, String name, Integer age, Gender gender, Date hireDate) {
        super(id, name, age, gender);
        this.hireDate = hireDate;
    }

    public Employee() {
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Department> getDepartments() {
        if (departments == null) {
            departments = new LinkedHashSet<>();
        }
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
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
    public Object calculateSalary(Object... objects) {
//        if (objects == null) {
//            throw new IllegalArgumentException("An Employee should have at least one remuneration.");
//        }
//        if (objects.length > 1) {
//            throw new IllegalArgumentException("An Employee cannot have more than one remuneration.");
//        }

        if (objects == null) {
            // NO ADDITIONAL LOGGING
            throw new MyDomainException("An Employee should have at least one remuneration.", "Employee");
        }
        if (objects.length == 0) {
            throw new MyDomainException("An Employee should have at least one remuneration.", "Employee");
        }

        return objects[0];
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", age=" + getAge() +
                ", hireDate=" + hireDate +
                ", projects=" + projects +
                ", departments=" + departments +
                '}';
    }

    // DOES NOT COMPILE
//    @Override
    private void dummyMethod() {
        System.out.println("do something");
    }

    public class Address extends DatabaseEntity {
        // should be an enum
        private String addressType;
        private String street;
        private String houseNo;
        private String zip;
        private String city;

        public Address(Integer id, String addressType, String street, String houseNo, String zip, String city) {
            super(id);
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
    }
}
