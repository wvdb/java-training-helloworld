package be.ictdynamic.helloworld.domain;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wvdbrand on 6/09/2017.
 */
public class Drawing implements Serializable{
    private List<Drawable> drawables;

    public List<Drawable> getDrawables() {
        return drawables;
    }

    public void setDrawables(List<Drawable> drawables) {
        this.drawables = drawables;
    }

    public Iterator<Object> getIterator() {
        // TODo : to impl
        return null;
    }
}
