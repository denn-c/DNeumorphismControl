package controls;

import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import neumorphism.Neumorphism;
import neumorphism.TypeNeumorphism;

public class DNeuToggleSwitch extends ToggleButton {

    private final ObjectProperty<TypeNeumorphism> neumorphism = new SimpleObjectProperty<>(TypeNeumorphism.INNER);
    private final DoubleProperty radius = new SimpleDoubleProperty(100);


    public DNeuToggleSwitch() {
        super();

        prefWidthProperty().set(90);
        prefHeightProperty().set(40);
        Region region = new Region();
        region.setMaxSize(getPrefHeight(),getPrefHeight());
        region.setMinSize(getPrefHeight(),getPrefHeight());
        region.setPrefSize(getPrefHeight(),getPrefHeight());

        setAlignment(Pos.CENTER_LEFT);
        setContentDisplay(ContentDisplay.LEFT);

        Neumorphism.setNeumorphism(region,TypeNeumorphism.OUTER, 50.0);
        region.setBackground(new Background(new BackgroundFill(Color.web("#243441"),new CornerRadii(getRadius()),null)));
        setGraphic(region);

        Neumorphism.setNeumorphism(this, getNeumorphism(), getRadius());

        textProperty().addListener((observable, oldValue, newValue) -> setText(""));
        fontProperty().addListener((observable, oldValue, newValue) -> setFont(Font.font(13)));

        this.neumorphismProperty().addListener((observable, oldValue, newValue) -> {
            TypeNeumorphism type = getNeumorphism();
            if (type == TypeNeumorphism.OUTER) {
                Neumorphism.setNeumorphism(this, TypeNeumorphism.OUTER, getRadius());

            } else if (type == TypeNeumorphism.INNER) {
                Neumorphism.setNeumorphism(this,   TypeNeumorphism.INNER, getRadius());

            } else {
                Neumorphism.setNeumorphism(this, TypeNeumorphism.NONE, getRadius());
            }
        });
        this.radiusProperty().addListener((observable, oldValue, newValue) -> {
            this.setBackground(new Background(new BackgroundFill(this.getBackground().getFills().get(0).getFill(), new CornerRadii((double) newValue), Insets.EMPTY)));
            region.setBackground(new Background(new BackgroundFill(Color.web("#243441"),new CornerRadii(getRadius()),null)));
        });

        this.prefHeightProperty().addListener((observable, oldValue, newValue) -> {
            region.setMaxSize(getPrefHeight(),getPrefHeight());
            region.setMinSize(getPrefHeight(),getPrefHeight());
            region.setPrefSize(getPrefHeight(),getPrefHeight());
        });

        setOnAction(event -> {
            if (this.isSelected()){
                setBackground(new Background(new BackgroundFill(Color.web("#0AFFEF"),new CornerRadii(getRadius()),null)));
                TranslateTransition transition = new TranslateTransition(Duration.millis(300), graphicProperty().get());
                transition.setToX((getPrefWidth() - graphicProperty().get().getBoundsInLocal().getWidth())-6);
                transition.play();
            }else{
                setBackground(new Background(new BackgroundFill(Color.web("#243441"),new CornerRadii(getRadius()),null)));
                TranslateTransition transition = new TranslateTransition(Duration.millis(300), graphicProperty().get());
                transition.setToX(0);
                transition.play();
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



}
