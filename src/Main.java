import containers.*;
import controls.DNeuButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import neumorphism.TypeNeumorphism;

public class Main extends Application {

    @Override
    public void start(Stage stage){

        DNeuPane root = new DNeuPane();
        root.setRadius(0);
        root.setNeumorphism(TypeNeumorphism.NONE);
        root.setPrefSize(1050,800);
        Stop[] stops = new Stop[] {
                new Stop(0, Color.rgb(200,200,200)),
                new Stop(1, Color.rgb(150,150,150))
        };
        LinearGradient gradient = new LinearGradient(0, 0, 1, 1, true, null, stops);

//        root.setColor(Color.MOCCASIN);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        DNeuAnchorPane dNeuAnchorPane = new DNeuAnchorPane();
        dNeuAnchorPane.setLayoutX(50);
        dNeuAnchorPane.setLayoutY(50);

        DNeuBorderPane dNeuBorderPane = new DNeuBorderPane();
        dNeuBorderPane.setLayoutX(300);
        dNeuBorderPane.setLayoutY(50);

        DNeuHBox dNueHBox = new DNeuHBox();
        dNueHBox.setLayoutX(550);
        dNueHBox.setLayoutY(50);

        DNeuPane dNeuPane = new DNeuPane();
        dNeuPane.setLayoutX(800);
        dNeuPane.setLayoutY(50);

        DNeuFlowPane dNeuFlowPane = new DNeuFlowPane();
        dNeuFlowPane.setLayoutX(50);
        dNeuFlowPane.setLayoutY(300);

        DNeuGridPane dNeuGridPane = new DNeuGridPane();
        dNeuGridPane.setLayoutX(300);
        dNeuGridPane.setLayoutY(300);

        DNeuStackPane dNeuStackPane = new DNeuStackPane();
        dNeuStackPane.setLayoutX(550);
        dNeuStackPane.setLayoutY(300);

        DNeuTextFlow dNeuTextFlow = new DNeuTextFlow();
        dNeuTextFlow.setLayoutX(800);
        dNeuTextFlow.setLayoutY(300);

        DNeuTilePane dNeuTilePane = new DNeuTilePane();
        dNeuTilePane.setLayoutX(50);
        dNeuTilePane.setLayoutY(550);

        DNeuVBox dNeuVBox = new DNeuVBox();
        dNeuVBox.setLayoutX(300);
        dNeuVBox.setLayoutY(550);

        DNeuButton dNeuButton = new DNeuButton();
        dNeuButton.setLayoutX(550);
        dNeuButton.setLayoutY(550);

        DNeuButton dNeuButton1 = new DNeuButton();
        dNeuButton1.setLayoutX(550);
        dNeuButton1.setLayoutY(650);

        DNeuButton dNeuButton2 = new DNeuButton();
        dNeuButton2.setLayoutX(550);
        dNeuButton2.setLayoutY(750);

        DNeuButton dNeuButton3 = new DNeuButton();
        dNeuButton3.setLayoutX(800);
        dNeuButton3.setLayoutY(550);

        DNeuButton dNeuButton4 = new DNeuButton();
        dNeuButton4.setLayoutX(800);
        dNeuButton4.setLayoutY(650);
        dNeuButton4.setExclude(true);
        root.getChildren().addAll(dNeuAnchorPane,dNeuBorderPane,dNueHBox,dNeuPane,dNeuFlowPane,dNeuGridPane,dNeuStackPane,dNeuTextFlow,dNeuTilePane,dNeuVBox,dNeuButton,dNeuButton1,dNeuButton2,dNeuButton3,dNeuButton4);
    }

    public static void main(String[] args) {
        launch(args);
    }

}