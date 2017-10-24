package be.ictdynamic.helloworld.domain;

/**
 * Created by admin on 29/09/2017.
 */
public class MobilePhone extends Remuneration{
    String type;
    String msisdn;

    public MobilePhone(String type, String msisdn, double cost) {
        super(cost);
        this.type = type;
        this.msisdn = msisdn;
    }

}
