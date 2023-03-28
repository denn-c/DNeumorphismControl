import containers.DNeumorphism;
import controls.DNeuButton;
import controls.DNeuToggleSwitch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import neumorphism.TypeNeumorphism;


public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 900, 900);
        primaryStage.setTitle("JavaFx");
        primaryStage.setScene(scene);
        root.setBackground(new Background(new BackgroundFill(Color.web("#243441"), null, null)));

        DNeuToggleSwitch dNeuThemeButton = new DNeuToggleSwitch();
        dNeuThemeButton.setLayoutX(100);
        dNeuThemeButton.setLayoutY(100);

        DNeuToggleSwitch dNeuThemeButton2 = new DNeuToggleSwitch();
        dNeuThemeButton2.setLayoutX(100);
        dNeuThemeButton2.setLayoutY(200);

        DNeuToggleSwitch dNeuThemeButton3 = new DNeuToggleSwitch();
        dNeuThemeButton3.setLayoutX(100);
        dNeuThemeButton3.setLayoutY(300);

        DNeuButton dNeuThemeButton4 = new DNeuButton();
        dNeuThemeButton4.setLayoutX(100);
        dNeuThemeButton4.setLayoutY(400);

        DNeuToggleSwitch dNeuThemeButton5 = new DNeuToggleSwitch();
        dNeuThemeButton5.setLayoutX(100);
        dNeuThemeButton5.setLayoutY(500);

        DNeuButton dNeuThemeButton6 = new DNeuButton();
        dNeuThemeButton6.setLayoutX(100);
        dNeuThemeButton6.setLayoutY(600);

        DNeuToggleSwitch dNeuThemeButton7 = new DNeuToggleSwitch();
        dNeuThemeButton7.setLayoutX(100);
        dNeuThemeButton7.setLayoutY(700);

        DNeumorphism dNeumorphism = new DNeumorphism();
        dNeumorphism.setPrefSize(200,400);
        dNeumorphism.setLayoutX(400);
        dNeumorphism.setLayoutY(100);

        root.getChildren().addAll(dNeuThemeButton,dNeuThemeButton2,dNeuThemeButton3,dNeuThemeButton4,dNeuThemeButton5,dNeuThemeButton6,dNeuThemeButton7,dNeumorphism);
        primaryStage.show();
    }
}
