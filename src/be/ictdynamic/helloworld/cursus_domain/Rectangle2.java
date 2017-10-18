package be.ictdynamic.helloworld.cursus_domain;

import java.util.Arrays;

/**
 * Created by admin on 9/09/2017.
 */
public class Rectangle2 implements Drawable2 {
    private static final int NUMBER_OF_ANGLES = 4;

    private int height;
    public int width;
    private int[] coordinates;

    public Rectangle2(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle2() {
        this(0, 0);
    }

    public Rectangle2(Rectangle2 rectangle) {
        this.height = rectangle.height;
        this.width = rectangle.width;
        this.coordinates = rectangle.coordinates;
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

    public Rectangle2 withHeight(int height) {
        this.height = height;
        return this;
    }

    public Rectangle2 withWidth(int width) {
        this.width = width;
        return this;
    }

    public Rectangle2 withCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle2)) return false;

        Rectangle2 that = (Rectangle2) o;

        if (height != that.height) return false;
        if (width != that.width) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + width;
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
