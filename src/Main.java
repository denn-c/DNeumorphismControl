import containers.*;
import controls.DNeuButton;
import controls.DNeuLabel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import neumorphism.TypeNeumorphism;

public class Main extends Application {

    @Override
    public void start(Stage stage){

        DNeuPane root = new DNeuPane();
        root.setRadius(0);
        root.setNeumorphism(TypeNeumorphism.NONE);
        root.setPrefSize(1050,800);
        root.setColor(Color.DARKMAGENTA);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


        DNeuLabel dNeuLabel = new DNeuLabel();
        dNeuLabel.setText("CHUYMA");
        dNeuLabel.setLayoutX(50);
        dNeuLabel.setLayoutY(50);

        DNeuPane dNuePane3 = new DNeuPane();
        dNuePane3.setLayoutX(550);
        dNuePane3.setLayoutY(50);
        dNuePane3.setNeumorphism(TypeNeumorphism.RIDGE);
        dNuePane3.setExclude(true);

        DNeuPane dNeuPane4 = new DNeuPane();
        dNeuPane4.setLayoutX(800);
        dNeuPane4.setLayoutY(50);

        DNeuPane dNeuPane5 = new DNeuPane();
        dNeuPane5.setLayoutX(50);
        dNeuPane5.setLayoutY(300);
        dNeuPane5.setNeumorphism(TypeNeumorphism.INSET);

        DNeuPane dNeuPane6 = new DNeuPane();
        dNeuPane6.setLayoutX(300);
        dNeuPane6.setLayoutY(300);
        dNeuPane4.setNeumorphism(TypeNeumorphism.RIDGE);

        DNeuButton dNeuButton = new DNeuButton();
        dNeuButton.setLayoutX(550);
        dNeuButton.setLayoutY(550);
        Image image = new Image("logo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        dNeuButton.setGraphic(imageView);

        DNeuButton dNeuButton1 = new DNeuButton();
        dNeuButton1.setLayoutX(550);
        dNeuButton1.setLayoutY(650);

        DNeuButton dNeuButton2 = new DNeuButton();
        dNeuButton2.setLayoutX(550);
        dNeuButton2.setLayoutY(750);

        DNeuButton dNeuButton3 = new DNeuButton();
        dNeuButton3.setLayoutX(800);
        dNeuButton3.setLayoutY(550);
        dNeuButton3.setExclude(true);
        dNeuButton3.setColor(Color.RED);

        DNeuButton dNeuButton4 = new DNeuButton();
        dNeuButton4.setLayoutX(800);
        dNeuButton4.setLayoutY(650);
        dNeuButton4.setExclude(true);
        root.getChildren().addAll(dNeuLabel,dNuePane3,dNeuPane4,dNeuPane5,dNeuPane6,dNeuButton,dNeuButton1,dNeuButton2,dNeuButton3,dNeuButton4);
    }

    public static void main(String[] args) {
        launch(args);
    }

}