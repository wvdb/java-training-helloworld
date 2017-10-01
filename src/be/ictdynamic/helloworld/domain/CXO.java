package be.ictdynamic.helloworld.domain;

import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class CXO extends Worker {
    public CXO_Type cxo_type;

    public enum CXO_Type {
        CIO(2),
        CEO(1),
        CFO(3);

        private final int cxoRank;

        CXO_Type(int cxoRank) {
            this.cxoRank = cxoRank;
        }

        public int getCxoRank() {
            return cxoRank;
        }
    }

    public CXO(String name, Integer age, Gender gender, Date hireDate) {
        super(name, age, gender, hireDate);
    }

    @Override
    public Float calculateTotalIncentiveCost() {
        return null;
    }

    @Override
    protected void setRemunerations(Remuneration[] remunerations) {
    }
}
