package be.ictdynamic.helloworld.cursus_domain;

/**
 * Created by admin on 17/10/2017.
 */
public class Shape {
    public static int count;
    private int[] coordinates;

    public Shape() {
    }

    public Shape(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Shape)) return false;
//
//        Shape shape = (Shape) o;
//
//        if (!Arrays.equals(coordinates, shape.coordinates)) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        return coordinates != null ? Arrays.hashCode(coordinates) : 0;
//    }
}
