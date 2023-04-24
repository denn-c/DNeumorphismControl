package neumorphism;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.Paint;

public interface DNeumorphism {
    Paint getColor();
    ObjectProperty<Paint> colorProperty();

    void setColor(Paint color);

    boolean isExclude();

    BooleanProperty excludeProperty();

    void setExclude(boolean exclude);
}
