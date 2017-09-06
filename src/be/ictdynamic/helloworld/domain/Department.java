package be.ictdynamic.helloworld.domain;

/**
 * Created by wvdbrand on 6/09/2017.
 */
public class Department extends DatabaseEntity {
  private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                '}';
    }
}
