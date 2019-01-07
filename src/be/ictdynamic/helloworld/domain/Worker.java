package be.ictdynamic.helloworld.domain;

import be.ictdynamic.helloworld.enums.Country;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public abstract class Worker extends DatabaseEntity implements Workable {
    static public boolean isEligibleForRemuneration = Boolean.TRUE;

    private String firstName;
    private String middleName;
    private String lastName;

    private Integer age;
    private Gender gender;
    private Date hireDate;
    private Date birthDate;
    protected Department department;
    private Set<Project> projects;
    protected Set<Remuneration> remunerations;
    private String socialSecurityNumber;
    private Country country;

    public Worker() {
    }

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public Worker(String firstName, Integer age, Gender gender, Date hireDate) {
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public String getMiddleName() {
        if (middleName == null ) {
            middleName = "";
        }
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        if (lastName == null ) {
            lastName = "";
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFullName(String firstName, String middleName, String lastName) {
        return firstName + " " + middleName + " " + lastName;
    }

    private String getFullName(String... partOfNames) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String partOfName : partOfNames) {
            stringBuilder.append(partOfName);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void testClassMethod() {
        System.out.println("The static method in Worker");
    }

    public void testInstanceMethod() {
        System.out.println("The instance method in Worker");
    }

    public String getFirstName() {
        if (firstName == null ) {
            firstName = "";
        }
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    abstract public Float calculateTotalIncentiveCost();

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Project> getProjects() {
        if (projects == null) {
            projects = new HashSet<>();
        }
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Remuneration> getRemunerations() {
        if (remunerations == null) {
            remunerations = new HashSet<>();
        }
        return remunerations;
    }

    protected abstract void setRemunerations(Set<Remuneration> remunerations);

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("birthDate is unknown");
        }

        this.birthDate = birthDate;

        Date currentDate = new Date();
        LocalDate localCurrentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate localBirthDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (localCurrentDate.minusYears(18).compareTo(localBirthDate) < 0) {
            throw new IllegalArgumentException("birthDate should be at least 18 years in the past");
        }
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Worker worker = (Worker) o;

        if (!getFirstName().equals(worker.getFirstName())) return false;
        if (!getMiddleName().equals(worker.getMiddleName())) return false;
        return getLastName().equals(worker.getLastName());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getMiddleName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }
}
