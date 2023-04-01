package neumorphism;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.Paint;

public interface DNeumorphism {

    TypeNeumorphism getNeumorphism();

    ObjectProperty<TypeNeumorphism> neumorphismProperty();

    void setNeumorphism(TypeNeumorphism neumorphism);

    double getRadius();

    DoubleProperty radiusProperty();

    void setRadius(double radius);

    Paint getColor();
    ObjectProperty<Paint> colorProperty();

    void setColor(Paint color);

}