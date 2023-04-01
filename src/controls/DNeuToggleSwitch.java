package controls;

import Themes.Dark;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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

public class DNeuToggleSwitch extends ToggleButton {/*

    private final ObjectProperty<TypeNeumorphism> neumorphism = new SimpleObjectProperty<>(TypeNeumorphism.INNER);
    private final DoubleProperty radius = new SimpleDoubleProperty(300);

    public DNeuToggleSwitch() {
        super();

        prefWidthProperty().set(90);
        prefHeightProperty().set(40);
        Neumorphism.setNeumorphism(this, getNeumorphism(), getRadius(), Color.WHITE);

        Pane background = new Pane();
        background.setMaxSize(getPrefWidth(),getPrefHeight());
        background.setMinSize(getPrefWidth(),getPrefHeight());
        background.setPrefSize(getPrefWidth(),getPrefHeight());
        background.setBackground(new Background(new BackgroundFill(this.getBackground().getFills().get(0).getFill(), new CornerRadii(getRadius()), Insets.EMPTY)));

        Region toggle = new Region();
        toggle.setMaxSize(getPrefHeight(),getPrefHeight());
        toggle.setMinSize(getPrefHeight(),getPrefHeight());
        toggle.setPrefSize(getPrefHeight(),getPrefHeight());
        toggle.setBackground(new Background(new BackgroundFill(this.getBackground().getFills().get(0).getFill(),new CornerRadii(getRadius()),null)));
        Neumorphism.setNeumorphism(toggle,TypeNeumorphism.OUTER, getRadius(),Color.WHITE);

        background.getChildren().add(toggle);
        setGraphic(background);

        textProperty().addListener(observable -> setText(""));
        fontProperty().addListener(observable -> setFont(Font.font(13)));
        contentDisplayProperty().addListener(observable -> setContentDisplay(ContentDisplay.GRAPHIC_ONLY));


        focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Neumorphism.setNeumorphismFocus(this,getNeumorphism(),getRadius());
                Neumorphism.setNeumorphismFocus(toggle,TypeNeumorphism.OUTER,getRadius());
            } else {
                Neumorphism.setNeumorphism(this,getNeumorphism(),getRadius(),Color.WHITE);
                Neumorphism.setNeumorphism(toggle,TypeNeumorphism.OUTER,getRadius(),Color.WHITE);
            }
        });

        this.neumorphismProperty().addListener(observable -> {
            TypeNeumorphism type = getNeumorphism();
            if (type == TypeNeumorphism.OUTER) {
                Neumorphism.setNeumorphism(this, TypeNeumorphism.OUTER, getRadius(),Color.WHITE);

            } else if (type == TypeNeumorphism.INNER) {
                Neumorphism.setNeumorphism(this,   TypeNeumorphism.INNER, getRadius(),Color.WHITE);

            } else {
                Neumorphism.setNeumorphism(this, TypeNeumorphism.NONE, getRadius(),Color.WHITE);
            }
        });

        this.radiusProperty().addListener((observable, oldValue, newValue) -> {
            this.setBackground(new Background(new BackgroundFill(this.getBackground().getFills().get(0).getFill(), new CornerRadii((double) newValue), Insets.EMPTY)));
            toggle.setBackground(new Background(new BackgroundFill(Dark.ROOT,new CornerRadii(getRadius()),null)));
            background.setBackground(new Background(new BackgroundFill(Dark.ROOT,new CornerRadii(getRadius()),null)));
        });

        this.prefHeightProperty().addListener(observable -> {
            background.setMaxSize(getPrefWidth(),getPrefHeight());
            background.setMinSize(getPrefWidth(),getPrefHeight());
            background.setPrefSize(getPrefWidth(),getPrefHeight());

            toggle.setMaxSize(getPrefHeight(),getPrefHeight());
            toggle.setMinSize(getPrefHeight(),getPrefHeight());
            toggle.setPrefSize(getPrefHeight(),getPrefHeight());
        });
        this.prefWidthProperty().addListener(observable -> {
            background.setMaxSize(getPrefWidth(),getPrefHeight());
            background.setMinSize(getPrefWidth(),getPrefHeight());
            background.setPrefSize(getPrefWidth(),getPrefHeight());
        });

        this.selectedProperty().addListener(observable-> {
            Timeline timeline = new Timeline();
            if (this.isSelected()){
                TranslateTransition transition = new TranslateTransition(Duration.millis(300),toggle);
                transition.setToX(background.getPrefWidth() - toggle.getPrefWidth());
                transition.play();

                timeline.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO, new KeyValue(alignmentProperty(), Pos.CENTER_LEFT)),
                        new KeyFrame(Duration.millis(300), new KeyValue(alignmentProperty(), Pos.CENTER_RIGHT))
                );

                timeline.setOnFinished(e -> background.setBackground(new Background(new BackgroundFill(Dark.CYAN,new CornerRadii(getRadius()),null))));

            }else{
                TranslateTransition transition = new TranslateTransition(Duration.millis(300),toggle);
                transition.setToX(0);
                transition.play();


                timeline.getKeyFrames().addAll(
                        new KeyFrame(Duration.ZERO, new KeyValue(alignmentProperty(), Pos.CENTER_RIGHT)),
                        new KeyFrame(Duration.millis(300), new KeyValue(alignmentProperty(), Pos.CENTER_LEFT))
                );
                timeline.setOnFinished(e -> background.setBackground(new Background(new BackgroundFill(this.getBackground().getFills().get(0).getFill(),new CornerRadii(getRadius()),null))));
            }
            timeline.play();
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
*/
}
