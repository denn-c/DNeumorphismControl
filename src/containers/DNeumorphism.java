package containers;

import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import neumorphism.Neumorphism;
import neumorphism.TypeNeumorphism;

public class DNeumorphism extends Region{

    private final ObjectProperty<TypeNeumorphism> neumorphism = new SimpleObjectProperty<>(TypeNeumorphism.OUTER);
    private final DoubleProperty radius = new SimpleDoubleProperty(14);

    public DNeumorphism() {
        super();
        setNeumorphism(neumorphism.get());
        neumorphismProperty().addListener((observable, oldValue, newValue) -> setNeumorphism(newValue));
        radiusProperty().addListener((observable, oldValue, newValue) -> setRadius(newValue.doubleValue()));
    }

    public TypeNeumorphism getNeumorphism() {
        return neumorphism.get();
    }

    public ObjectProperty<TypeNeumorphism> neumorphismProperty() {
        return neumorphism;
    }

    public void setNeumorphism(TypeNeumorphism neumorphism) {
        this.neumorphism.set(neumorphism);
        Neumorphism.setNeumorphism(this, neumorphism, radius.get());
    }

    public double getRadius() {
        return radius.get();
    }

    public DoubleProperty radiusProperty() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius.set(radius);
        setBackground(new Background(new BackgroundFill(getBackground().getFills().get(0).getFill(), new CornerRadii(radius), Insets.EMPTY)));
    }
}
