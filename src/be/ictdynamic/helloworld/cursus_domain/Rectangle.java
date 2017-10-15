package be.ictdynamic.helloworld.cursus_domain;

import java.util.Arrays;

/**
 * Created by admin on 9/09/2017.
 */
public class Rectangle implements Drawable2 {
    public static final int NUMBER_OF_ANGLES = 4;
    public static int numberORectanglesConstructed;

    private int height;
    public int width;
    private int[] coordinates;

    public Rectangle(int height, int width, int[] coordinates) {
        this.height = height;
        this.width = width;
        this.coordinates = coordinates;
        numberORectanglesConstructed += 1;
    }

    public Rectangle() {
        this(0, 0, null);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.height, rectangle.width, rectangle.coordinates);
    }

    public int getHeight() {
        return height;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    public  int getWidth() {
        return width;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int getArea() {
        return getHeight() * getWidth();
    }

    public int getPerimeter() {
        return (getHeight() + getWidth()) * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;

        Rectangle rectangle = (Rectangle) o;

        if (getHeight() != rectangle.getHeight()) return false;
        if (getWidth() != rectangle.getWidth()) return false;
        return Arrays.equals(getCoordinates(), rectangle.getCoordinates());

    }

    public static int getNumberOfAngles() {
        return NUMBER_OF_ANGLES;
    }

    @Override
    public int hashCode() {
        int result = getHeight();
        result = 31 * result + getWidth();
        result = 31 * result + (getCoordinates() != null ? Arrays.hashCode(getCoordinates()) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                ", coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
