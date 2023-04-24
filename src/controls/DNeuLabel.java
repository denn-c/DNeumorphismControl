package controls;

import javafx.beans.property.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import neumorphism.DNeumorphismContainer;
import neumorphism.Neumorphism;
import neumorphism.TypeNeumorphism;

public class DNeuLabel extends Label implements DNeumorphismContainer {

    private final ObjectProperty<TypeNeumorphism> neumorphism = new SimpleObjectProperty<>(TypeNeumorphism.RAISED);
    private final ObjectProperty<Paint> color = new SimpleObjectProperty<>(Color.web("#243441"));
    private final DoubleProperty radius = new SimpleDoubleProperty(14);
    private final BooleanProperty exclude = new SimpleBooleanProperty(false);
    private final BooleanProperty textNeumorphism = new SimpleBooleanProperty(true);

    public DNeuLabel() {
        super();
        setColor(getColor());
        setText("DNeuLabel");
        setAlignment(Pos.CENTER);
        setFont(Font.font(null, FontWeight.BOLD,60));
        neumorphismProperty().addListener((observable, oldValue, newValue) -> setNeumorphism(newValue));
        radiusProperty().addListener((observable, oldValue, newValue) -> setRadius(newValue.doubleValue()));
        colorProperty().addListener((observable, oldValue, newValue) -> setColor(newValue));
        textNeumorphismProperty().addListener((observable, oldValue, newValue) -> setTextNeumorphism(newValue));
    }

    public TypeNeumorphism getNeumorphism() {
        return neumorphism.get();
    }

    public ObjectProperty<TypeNeumorphism> neumorphismProperty() {
        return neumorphism;
    }

    public void setNeumorphism(TypeNeumorphism neumorphism) {
        this.neumorphism.set(neumorphism);
        Neumorphism.setNeumorphism(this, neumorphism, getRadius(), getColor(), isTextNeumorphism());
    }

    public double getRadius() {
        return radius.get();
    }

    public DoubleProperty radiusProperty() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius.set(radius);
        Neumorphism.setNeumorphism(this, getNeumorphism(), getRadius(), getColor(), isTextNeumorphism());

    }

    public Paint getColor() {
        return color.get();
    }

    public ObjectProperty<Paint> colorProperty() {
        return color;
    }

    public void setColor(Paint color) {
        this.color.set(color);
        Neumorphism.setNeumorphism(this, getNeumorphism(), getRadius(), color, isTextNeumorphism());
        if (isTextNeumorphism()) {
            setTextFill(getColor());
        }else {
            setTextFill(Neumorphism.getTextFill(getColor()));
        }
    }

    public boolean isExclude() {
        return exclude.get();
    }

    public BooleanProperty excludeProperty() {
        return exclude;
    }

    public void setExclude(boolean exclude) {
        this.exclude.set(exclude);
        setTextFill(Neumorphism.getTextFill(getColor()));
    }
    public boolean isTextNeumorphism() {
        return textNeumorphism.get();
    }

    public BooleanProperty textNeumorphismProperty() {
        return textNeumorphism;
    }

    public void setTextNeumorphism(boolean textNeumorphism) {
        this.textNeumorphism.set(textNeumorphism);
        Neumorphism.setNeumorphism(this, getNeumorphism(), getRadius(), getColor(), textNeumorphism);
    }
}
