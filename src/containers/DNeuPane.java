package containers;

import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import neumorphism.Neumorphism;
import neumorphism.TypeNeumorphism;

public class DNeuPane extends Pane{

    private final ObjectProperty<TypeNeumorphism> neumorphism = new SimpleObjectProperty<>(TypeNeumorphism.OUTER);
    private final DoubleProperty radius = new SimpleDoubleProperty(14);

    public DNeuPane() {
        super();
        Neumorphism.setNeumorphism(this, getNeumorphism(), getRadius());

        this.neumorphismProperty().addListener((observable, oldValue, newValue) -> {
            TypeNeumorphism type = getNeumorphism();
            if (type == TypeNeumorphism.OUTER) {
                Neumorphism.setNeumorphism(this, TypeNeumorphism.OUTER, getRadius());

            } else if (type == TypeNeumorphism.INNER) {
                Neumorphism.setNeumorphism(this, TypeNeumorphism.INNER, getRadius());

            } else {
                Neumorphism.setNeumorphism(this, TypeNeumorphism.NONE, getRadius());
            }
        });
        this.radiusProperty().addListener((observable, oldValue, newValue) -> this.setBackground(new Background(new BackgroundFill(this.getBackground().getFills().get(0).getFill(), new CornerRadii((double) newValue), Insets.EMPTY))));
    }

    public TypeNeumorphism getNeumorphism() {
        return neumorphism.get();
    }

    public ObjectProperty<TypeNeumorphism> neumorphismProperty() {
        return neumorphism;
    }

    public void setNeumorphism(TypeNeumorphism neumorphism) {
        this.neumorphism.set(neumorphism);
    }

    public double getRadius() {
        return radius.get();
    }

    public DoubleProperty radiusProperty() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius.set(radius);
    }
}
