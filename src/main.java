import controls.DNeuToggleSwitch;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("JavaFx");
        primaryStage.setScene(scene);

        Pane pane = new Pane();
        pane.setPrefHeight(400);
        pane.setPrefWidth(400);
        pane.setBackground(new Background(new BackgroundFill(Color.web("#243441"), null, null)));

        DNeuToggleSwitch dNeuThemeButton = new DNeuToggleSwitch();
        dNeuThemeButton.setLayoutX(100);
        dNeuThemeButton.setLayoutY(100);
        dNeuThemeButton.setText("CHUYMA");
        dNeuThemeButton.setTextFill(Color.WHITE);
        pane.getChildren().add(dNeuThemeButton);

        root.getChildren().add(pane);
        primaryStage.show();

    }
}
