package be.ictdynamic.helloworld.cursus_domain;

/**
 * Created by admin on 9/09/2017.
 */
public class Square extends Rectangle {
    public Square(int side, int[] coordinates) {
        super(side, side, coordinates);
    }

    // down to earth solution : support changeFormat and make rectangle setHeight + rectangle setWidth protected
    // problem : rectangle cannot be changed anymore
    public void changeFormat(int side) {
        super.setHeight(side);
        super.setWidth(side);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setHeight(int side) {
        super.setHeight(side);
//        setWidth(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(int side) {
        super.setWidth(side);
//        setHeight(side);
        super.setHeight(side);
    }

    // NO GOOD : Why doesn't Java allow overriding of static methods?
    // theoretical blah blah
//    @Override
    public static int getNumberOfAngles() {
        return NUMBER_OF_ANGLES;
    }
}
