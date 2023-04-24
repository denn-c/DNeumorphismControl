package controls;

import javafx.beans.property.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import neumorphism.DNeumorphism;
import neumorphism.Neumorphism;
import neumorphism.TypeNeumorphism;

public class DNeuImageView extends ImageView implements DNeumorphism {

    private final ObjectProperty<Paint> color = new SimpleObjectProperty<>(Color.web("#243441"));
    private final BooleanProperty exclude = new SimpleBooleanProperty(false);

    public DNeuImageView(){
        super();
        setFitWidth(200);
        setFitHeight(150);
        Neumorphism.setNeumorphism(this,TypeNeumorphism.RAISED,null,getColor());
        colorProperty().addListener((observable, oldValue, newValue) -> setColor(newValue));
        excludeProperty().addListener((observable, oldValue, newValue) -> setExclude(newValue));
        imageProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setFitWidth(newValue.getWidth());
                setFitHeight(newValue.getHeight());
                setPreserveRatio(true);
            }
        });
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
        Neumorphism.setNeumorphism(this, TypeNeumorphism.RAISED,null, color);
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
}
