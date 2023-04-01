package containers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import neumorphism.DNeumorphism;
import neumorphism.Neumorphism;
import neumorphism.TypeNeumorphism;

public class DNeuAnchorPane extends AnchorPane implements DNeumorphism {

    private final ObjectProperty<TypeNeumorphism> neumorphism = new SimpleObjectProperty<>(TypeNeumorphism.OUTER);
    private final ObjectProperty<Paint> color = new SimpleObjectProperty<>(Color.web("#243441"));
    private final DoubleProperty radius = new SimpleDoubleProperty(14);

    public DNeuAnchorPane() {
        super();
        setPrefSize(200,200);
        setNeumorphism(neumorphism.get());
        neumorphismProperty().addListener((observable, oldValue, newValue) -> setNeumorphism(newValue));
        radiusProperty().addListener((observable, oldValue, newValue) -> setRadius(newValue.doubleValue()));
        colorProperty().addListener((observable, oldValue, newValue) -> {
            setColor(newValue);
            getChildren().stream()
                    .filter(child -> child instanceof DNeumorphism)
                    .forEach(child -> ((DNeumorphism) child).setColor(newValue));
        });

        getChildren().addListener((ListChangeListener<Node>) change -> getChildren().stream()
                .filter(child -> child instanceof DNeumorphism)
                .forEach(child -> ((DNeumorphism) child).setColor(getColor())));

    }

    @Override
    public TypeNeumorphism getNeumorphism() {
        return neumorphism.get();
    }

    @Override
    public ObjectProperty<TypeNeumorphism> neumorphismProperty() {
        return neumorphism;
    }

    @Override
    public void setNeumorphism(TypeNeumorphism neumorphism) {
        this.neumorphism.set(neumorphism);
        Neumorphism.setNeumorphism(this, neumorphism, getRadius(), (Color) getColor());
    }

    @Override
    public double getRadius() {
        return radius.get();
    }

    @Override
    public DoubleProperty radiusProperty() {
        return radius;
    }

    @Override
    public void setRadius(double radius) {
        this.radius.set(radius);
        Neumorphism.setNeumorphism(this, getNeumorphism(), radius, (Color) getColor());
    }

    @Override
    public Paint getColor() {
        return color.get();
    }

    @Override
    public ObjectProperty<Paint> colorProperty() {
        return color;
    }

    @Override
    public void setColor(Paint color) {
        this.color.set(color);
        Neumorphism.setNeumorphism(this, getNeumorphism(), getRadius(), (Color) color);
    }
}