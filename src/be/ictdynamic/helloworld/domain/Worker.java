package be.ictdynamic.helloworld.domain;

import be.ictdynamic.helloworld.exception.MyDomainException;
import be.ictdynamic.helloworld.exception.MyDomainException2;

import java.util.Date;

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
    protected Department department;
    private Project[] projects;
    protected Remuneration[] remunerations;

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

    @Override
    public String getFullName(String... partOfNames) {
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

    public Project[] getProjects() {
        if (projects == null) {
            projects = new Project[5];
        }
        return projects;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }

    public Remuneration[] getRemunerations() {
        if (remunerations == null) {
            remunerations = new Remuneration[4];
        }
        return remunerations;
    }

    protected abstract void setRemunerations(Remuneration[] remunerations);

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
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
