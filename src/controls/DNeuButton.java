package controls;

import javafx.beans.property.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import neumorphism.DNeumorphismRegion;
import neumorphism.Neumorphism;
import neumorphism.TypeNeumorphism;

public class DNeuButton extends Button implements DNeumorphismRegion {
    private final ObjectProperty<Paint> color = new SimpleObjectProperty<>(Color.web("#243441"));
    private final DoubleProperty radius = new SimpleDoubleProperty(200);
    private final BooleanProperty exclude = new SimpleBooleanProperty(false);
    private Paint mainColor;

    public DNeuButton() {
        super();
        Neumorphism.setNeumorphism(this, TypeNeumorphism.RAISED, getRadius(), getColor());
        setPrefSize(120, 40);
        setText("DNeuButton");
        setTextFill(Neumorphism.getTextFill(getColor()));

        radiusProperty().addListener((observable, oldValue, newValue) -> setRadius(newValue.doubleValue()));
        colorProperty().addListener((observable, oldValue, newValue) -> setColor(newValue));
        focusedProperty().addListener((observable, oldValue, newValue) -> {
            mainColor = getColor();
            if (newValue) {
                Neumorphism.setNeumorphismActive(this, TypeNeumorphism.RAISED, getRadius(), getColor());
            } else {
                setColor(mainColor);
            }
        });
        graphicProperty().addListener((observable) -> {
            if (getText().equals("DNeuButton")) {
                setText(null);
            }
        });
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
        Neumorphism.setNeumorphism(this, TypeNeumorphism.RAISED, radius, getColor());
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
        Neumorphism.setNeumorphism(this, TypeNeumorphism.RAISED, getRadius(), color);
        setTextFill(Neumorphism.getTextFill(color));
    }

    @Override
    public boolean isExclude() {
        return exclude.get();
    }

    @Override
    public BooleanProperty excludeProperty() {
        return exclude;
    }

    @Override
    public void setExclude(boolean exclude) {
        this.exclude.set(exclude);
    }

    @Override
    public void arm() {
        super.arm();
        Neumorphism.setNeumorphismActive(this, TypeNeumorphism.RIDGE, getRadius(), getColor());
    }

    @Override
    public void disarm() {
        super.disarm();
        Neumorphism.setNeumorphismActive(this, TypeNeumorphism.RAISED, getRadius(), mainColor);
    }
}