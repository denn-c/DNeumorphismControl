package neumorphism;

import javafx.beans.property.DoubleProperty;

public interface DNeumorphismRegion extends DNeumorphism{

    double getRadius();

    DoubleProperty radiusProperty();

    void setRadius(double radius);
}