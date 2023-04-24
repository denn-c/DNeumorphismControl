package containers;

import javafx.beans.property.*;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import neumorphism.*;

public class DNeuTilePane extends TilePane implements DNeumorphismContainer {

    private final ObjectProperty<TypeNeumorphism> neumorphism = new SimpleObjectProperty<>(TypeNeumorphism.RAISED);
    private final ObjectProperty<Paint> color = new SimpleObjectProperty<>(Color.web("#243441"));
    private final DoubleProperty radius = new SimpleDoubleProperty(14);
    private final BooleanProperty exclude = new SimpleBooleanProperty(false);

    public DNeuTilePane() {
        super();
        setPrefSize(200,200);
        setNeumorphism(neumorphism.get());
        neumorphismProperty().addListener((observable, oldValue, newValue) -> setNeumorphism(newValue));
        radiusProperty().addListener((observable, oldValue, newValue) -> setRadius(newValue.doubleValue()));
        colorProperty().addListener((observable, oldValue, newValue) -> childrenApplyColor(newValue));
        getChildren().addListener((ListChangeListener<Node>) change -> childrenApplyColor(getColor()));
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
        Neumorphism.setNeumorphism(this, neumorphism, getRadius(), getColor());
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
        Neumorphism.setNeumorphism(this, getNeumorphism(), radius, getColor());
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
        Neumorphism.setNeumorphism(this, getNeumorphism(), getRadius(), color);
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

    private void childrenApplyColor(Paint paint){
        getChildren().stream()
                .filter(child ->(child instanceof DNeumorphism) && !((DNeumorphism) child).excludeProperty().get())
                .forEach(child -> ((DNeumorphism) child).setColor(paint));
    }
}