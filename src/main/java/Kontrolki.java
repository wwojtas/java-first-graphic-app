import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Kontrolki extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Stage ->   Scene   ->   StackPane   ->   Text

        Font font = Font.font("Arial", FontWeight.BOLD, 16);
//        System.out.println(Font.getFamilies()); // jakie czcionki są w systemie
        // HEX color
        Color color = Color.web("#0f0000");

        // Label - nazwa kontrolki
        Label label = new Label("Moja pierwsza labelka");
        label.setLayoutX(10);
        label.setLayoutX(35);
//        label.setFont(new Font(20));
        label.setFont(font);

//        label.setTextFill(Color.RED); // kolor z palety
        label.setTextFill(color); // kolor włąsny dedykowany

        label.setMaxWidth(80);
        label.setWrapText(true);
//        label.setRotate(15); // obrocenie tekstu




        Group group = new Group();
        group.getChildren().add(label);

        Scene scene = new Scene(group, 800, 600, Color.ANTIQUEWHITE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplikacja kontrolki");
        primaryStage.show();

    }
}
