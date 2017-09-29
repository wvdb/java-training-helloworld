package be.ictdynamic.helloworld.cursus_domain;

/**
 * Created by admin on 9/09/2017.
 */
public class Rectangle {
    private int height;
    public int width;
    private int[] coordinates;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle() {

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

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
