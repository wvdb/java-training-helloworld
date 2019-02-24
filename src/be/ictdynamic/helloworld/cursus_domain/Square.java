package be.ictdynamic.helloworld.cursus_domain;

/**
 * Created by admin on 9/09/2017.
 */
public class Square extends Rectangle {
    public int MINIMUM_AREA = 100;
    public static final int MAXIMUM_AREA = 10000;

    public Square(int side, int[] coordinates) {
        super(side, side, coordinates);
    }

    public Square() {
    }

    public void setSide(int side) {
        super.setHeight(side);
        super.setWidth(side);
//        setHeight(side);
//        setWidth(side);
    }

    public long getWidthAsLong(int dummy) {
        return width;
    }

    @Override
    protected double getWidthAsDouble() {
        return width;
    }

    @Override
    public void setHeight(int height) {
        setSide(height);
//        setWidth(height);
//        super.setHeight(side);
//        super.setWidth(side);
    }

    @Override
    public void setWidth(int width) {
        System.out.println("invoking the setWidth method of Square");
        this.height = width;
        this.width = width;
//        setSide(width);
//        setHeight(widht);
////        super.setWidth(side);
//        super.setHeight(side);
    }

    // NO GOOD : Why doesn't Java allow overriding of static methods?
    // theoretical blah blah

    // be carefull !!! Square.getNumberOfAngles() works (static method will be inherited))
//    @Override
//    public static int getNumberOfAngles() {
//        return NUMBER_OF_ANGLES;
//    }
}
