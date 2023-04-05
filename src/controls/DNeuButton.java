package controls;

import javafx.beans.property.*;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import neumorphism.Neumorphism;
import neumorphism.DNeumorphism;
import neumorphism.TypeNeumorphism;

public class DNeuButton extends Button implements DNeumorphism {
    private final ObjectProperty<Paint> color = new SimpleObjectProperty<>(Color.web("#243441"));
    private final DoubleProperty radius = new SimpleDoubleProperty(200);
    private final BooleanProperty exclude = new SimpleBooleanProperty(false);

    private final Region region = new Region();
    private Paint mainColor;

    public DNeuButton() {
        super();
        Neumorphism.setNeumorphism(this,TypeNeumorphism.RAISED,getRadius(),getColor());
        setPrefSize(120, 40);
        setContentDisplay(ContentDisplay.CENTER);
        region.setPrefSize(getPrefWidth(),getPrefHeight());
        setGraphic(region);
        setText("DNeuButton");
        setTextFill(Neumorphism.getTextFill(getColor()));

        radiusProperty().addListener((observable, oldValue, newValue) -> setRadius(newValue.doubleValue()));
        colorProperty().addListener((observable, oldValue, newValue) -> setColor(newValue));

        prefHeightProperty().addListener(observable -> region.setPrefSize(getPrefWidth(),getPrefHeight()));
        prefWidthProperty().addListener(observable -> region.setPrefSize(getPrefWidth(),getPrefHeight()));

        focusedProperty().addListener((observable, oldValue, newValue) -> {
            mainColor = getColor();
            if (newValue){
                Neumorphism.setNeumorphismFocus(this,TypeNeumorphism.RAISED,getRadius(), getColor());
            }else {
                setColor(mainColor);
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
        Neumorphism.setNeumorphismFocus(region,TypeNeumorphism.INSET,getRadius(), getColor());
        super.arm();
    }

    @Override
    public void disarm() {
        Neumorphism.setNeumorphismFocus(region,TypeNeumorphism.NONE,getRadius(), mainColor);
        super.disarm();
    }
}