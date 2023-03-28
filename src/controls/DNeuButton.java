package controls;

import Themes.Dark;
import javafx.animation.PauseTransition;
import javafx.beans.DefaultProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.util.Duration;
import neumorphism.Neumorphism;
import neumorphism.TypeNeumorphism;

public class DNeuButton extends Button {

    public final ObjectProperty<TypeNeumorphism> neumorphism = new SimpleObjectProperty<>(TypeNeumorphism.OUTER);
    public final DoubleProperty radius = new SimpleDoubleProperty(300);

    public DNeuButton() {
        super();

        prefWidthProperty().set(110);
        prefHeightProperty().set(40);
        setTextFill(Color.WHITE);
        setText("DNeuButton");

        Neumorphism.setNeumorphism(this, getNeumorphism(), getRadius());

        neumorphismProperty().addListener(observable -> {
            TypeNeumorphism type = getNeumorphism();
            if (type == TypeNeumorphism.OUTER) {
                Neumorphism.setNeumorphism(this, TypeNeumorphism.OUTER, getRadius());

            } else if (type == TypeNeumorphism.INNER) {
                Neumorphism.setNeumorphism(this, TypeNeumorphism.INNER, getRadius());

            } else {
                Neumorphism.setNeumorphism(this, TypeNeumorphism.NONE, getRadius());
            }
        });

        radiusProperty().addListener((observable, oldValue, newValue) -> this.setBackground(new Background(new BackgroundFill(this.getBackground().getFills().get(0).getFill(), new CornerRadii((double) newValue), Insets.EMPTY))));

        focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Neumorphism.setNeumorphismFocus(this, getNeumorphism(), getRadius());
            } else {
                Neumorphism.setNeumorphism(this, getNeumorphism(), getRadius());
            }
        });
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

    @Override
    public void fire() {
        setColorAction();
        PauseTransition pauseTransition = new PauseTransition(Duration.millis(100));
        pauseTransition.setOnFinished(event -> {
            super.fire();
            setColor();
        });
        pauseTransition.play();
    }

    private void setColor() {
        setBackground(new Background(new BackgroundFill(Dark.ROOT, new CornerRadii(getRadius()), Insets.EMPTY)));
    }

    private void setColorAction() {
        setBackground(new Background(new BackgroundFill(Dark.FOCUS_SHADE, new CornerRadii(getRadius()), Insets.EMPTY)));
    }
}
