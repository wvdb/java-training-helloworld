package be.ictdynamic.helloworld.cursus_domain;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by admin on 9/09/2017.
 */
public class Rectangle extends Shape implements Drawable2 {
    public static final int NUMBER_OF_ANGLES = 4;
    public static final int MINIMUM_AREA = 16;
    public static int numberORectanglesConstructed;

    public String nameOfRectangle;

    private int height;
    public int width;

    public Rectangle(int height, int width, int[] coordinates) {
        // TO EXPLAIN : super() should be first statement
        super(coordinates);
        this.height = height;
        this.width = width;
       numberORectanglesConstructed += 1;
    }

    public Rectangle() {
        this(0, 0, null);
    }

    @Override
    public void dummy() {

    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.height, rectangle.width, rectangle.getCoordinates());
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void setDefaultColor(Graphics graphics) {

    }

    protected void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public long getWidthAsLong() {
        return width;
    }

    double getWidthAsDouble() {
        return width;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    public int getArea() {
        return getHeight() * getWidth();
    }

    public int getPerimeter() {
        return (getHeight() + getWidth()) * 2;
    }

    public static int getNumberOfAngles() {
        return NUMBER_OF_ANGLES;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        if (!super.equals(o)) return false;

        Rectangle rectangle = (Rectangle) o;

        if (height != rectangle.height) return false;
        if (width != rectangle.width) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + height;
        result = 31 * result + width;
        return result;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                ", coordinates=" + Arrays.toString(super.getCoordinates()) +
                '}';
    }
}
