package neumorphism;

import javafx.beans.property.ObjectProperty;

public interface DNeumorphismContainer extends DNeumorphismRegion {
    TypeNeumorphism getNeumorphism();

    ObjectProperty<TypeNeumorphism> neumorphismProperty();

    void setNeumorphism(TypeNeumorphism neumorphism);
}
