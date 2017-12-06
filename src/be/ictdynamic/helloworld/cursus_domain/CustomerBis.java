package be.ictdynamic.helloworld.cursus_domain;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class CustomerBis extends Customer {
    public float dummy2() {
        return 10.0f;
    }

    @Override
    public int dummy() {
        return 2;
    }

    // example of a hidden method
    // a private method cannot be overridden
//    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
