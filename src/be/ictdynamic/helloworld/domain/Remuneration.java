package be.ictdynamic.helloworld.domain;

import java.util.UUID;

/**
 * Created by admin on 29/09/2017.
 */
public abstract class Remuneration extends DatabaseEntity {
    private double cost;

    public Remuneration(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}