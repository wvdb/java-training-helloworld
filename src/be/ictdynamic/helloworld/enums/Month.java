package be.ictdynamic.helloworld.enums;

/**
 * Created by admin on 22/09/2017.
 */
public enum Month {
    JANUARY(new String[]{"januari", "January"}, 1),
    FEBRUARY(new String[]{"februari", "February"}, 2),
    NOVEMBER(new String[]{"november", "November"}, 11),
    DECEMBER(new String[]{"december", "December"}, 12);

    String[] monthLanguages;
    int index;

    Month(String[] monthLanguages, int index) {
        this.monthLanguages = monthLanguages;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String[] getMonthLanguages() {
        return monthLanguages;
    }

// we don't support the mutator method

}
