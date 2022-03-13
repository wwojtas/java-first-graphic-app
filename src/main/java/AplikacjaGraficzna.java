
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.PrimitiveIterator;

public class AplikacjaGraficzna extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Stage ->   Scene   ->   StackPane   ->   Text
        // Stage to takie okno
        // w Stage umieszczamy płótno -> płótnem jest Scene ->
        // -> na płótnie mówimy co jest naszym początkiem wyrysowania elementu,
        // co jest naszym korzeniem, i od tego krzenia możemy rysować kolejne elementy
        // przykładem elementu jest Text

        // tworzymy relacje między obiektami
        // scena to jakby płótno
        // primaryStage - to takie okno, w oknie umieszczamy płótno scene

        Text text = new Text("Tekst z 1 aplikacji graficznej");
        StackPane stackPane = new StackPane();  // nazywany jako root
        stackPane.getChildren().add(text);
        // do naszego roota przekazujemy korzeń
        Scene scene = new Scene(stackPane);

        // stage - ustawianie sceny
        primaryStage.setScene(scene);
        // kolejne elementy jakie można ustawić przez metody
        primaryStage.setTitle("Moja aplikacja"); // - tytuł
        primaryStage.setX(200); // ustawienia wyswietlania - wspolrz. X
        primaryStage.setY(400);

        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(400);

//        primaryStage.initStyle(StageStyle.DECORATED);
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.initStyle(StageStyle.UTILITY); // mozliwe tylko zamknięcie okkna
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setFullScreen(false);


        // pokaż okno aplikacji
        primaryStage.show();



    }
}
