import containers.DNeuAnchorPane;
import containers.DNeuPane;
import containers.DNueHBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import neumorphism.TypeNeumorphism;

public class Main extends Application {

    @Override
    public void start(Stage stage){

        DNeuAnchorPane root = new DNeuAnchorPane();
        root.setRadius(0);
        root.setNeumorphism(TypeNeumorphism.NONE);
        root.setPrefSize(900,800);
        root.setColor(Color.MAROON);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        DNueHBox dNueHBox = new DNueHBox();
        dNueHBox.setLayoutX(200);
        dNueHBox.setLayoutY(200);


        DNeuAnchorPane dNeuAnchorPane = new DNeuAnchorPane();
        dNeuAnchorPane.setLayoutX(500);
        dNeuAnchorPane.setLayoutY(200);

        DNeuPane dNeuPane = new DNeuPane();
        dNeuPane.setLayoutX(200);
        dNeuPane.setLayoutY(500);



        root.getChildren().addAll(dNueHBox,dNeuAnchorPane,dNeuPane);
    }

    public static void main(String[] args) {
        launch(args);
    }

}