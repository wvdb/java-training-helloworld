package be.ictdynamic.helloworld.domain;

/**
 * Created by admin on 29/09/2017.
 */
public class MealVoucher extends Remuneration{
    String name;

    public MealVoucher(String name, double cost) {
        super(cost);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
