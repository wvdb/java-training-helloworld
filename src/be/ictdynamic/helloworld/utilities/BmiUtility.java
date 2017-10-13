package be.ictdynamic.helloworld.utilities;

/**
 * Created by admin on 12/10/2017.
 */
public final class BmiUtility {
    public final static float calculateBmi(final float lengte, final int gewicht) {
        // BMI = gewicht / lengte (in m) in kwadraat
        return gewicht / (lengte * lengte);
    }
}
