package be.ictdynamic.helloworld.cursus_domain;

import java.awt.*;

/**
 * Created by admin on 10/09/2017.
 */
public interface Drawable2 {
    Color defaultColor = Color.BLUE;

    int getHeight();

    public default void setDefaultColor(Graphics graphics) {
        graphics.setColor(defaultColor);
    }
}
