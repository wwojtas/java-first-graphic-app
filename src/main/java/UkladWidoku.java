import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UkladWidoku extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Layout


        // HBox - ustawienie horyzontalne ===========================================
        //
        Button menuButton = new Button("Menu");
        Button kontaktButton = new Button("Kontakt");
        Button zamowienieButton = new Button("Zamowienie");

        HBox hBox = new HBox(); // instancja HBox
//        hBox.getChildren().add(menuButton);
//        hBox.getChildren().add(kontaktButton);
//        hBox.getChildren().add(zamowienieButton);
        hBox.getChildren().addAll(menuButton, kontaktButton, zamowienieButton);
        hBox.setSpacing(10); // odstep między kontrolkami
        hBox.setPadding(new Insets(10,5,10,5));
        hBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // VBox - ustawienie wertykalne ===========================================
        ImageView pizzaImageView = new ImageView(new Image("obrazki/ikony/pizza.png"));
        Label pizzaLabel = new Label("Pizza", pizzaImageView);
        ImageView hamburgerImageView = new ImageView(new Image("obrazki/ikony/hamburger.png"));
        Label hamburgerLabel = new Label("Hamburger", hamburgerImageView);
        ImageView napojeImageView = new ImageView(new Image("obrazki/ikony/napoje.png"));
        Label napojeLabel = new Label("Napoje", napojeImageView);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(pizzaLabel, hamburgerLabel, napojeLabel);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        vBox.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        // StackPane ===========================================
        // StackPane - stos - układanie elementu 1 na drugim
        ImageView pizzaDuzaImageView = new ImageView(new Image("obrazki/pizza/hot-dog.png"));
        Label opisLabel = new Label("Hot dog");

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(pizzaDuzaImageView, opisLabel);
        stackPane.setAlignment(Pos.TOP_CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        // FlowPane ===========================================
        // FlowPane - pionowo -  jesli nie starczy miejsca - elementy przekłądane do następnej kolumny
        ImageView imageView1 = new ImageView("obrazki/pizza/hot-dog.png");
        ImageView imageView2 = new ImageView("obrazki/pizza/house.png");
        ImageView imageView3 = new ImageView("obrazki/pizza/pizza-duza.png");

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(imageView1, imageView2, imageView3);
        flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setMaxWidth(60);
        flowPane.setHgap(5); // odstepy Horizontal
        flowPane.setVgap(10); // odstepy Vertical
        flowPane.setPadding(new Insets(5));

        // GridPane ===========================================
        // GridPane - siatka
        Button minusButton = new Button("-");
        minusButton.setPrefSize(30,30);
        Button plusButton = new Button("+");
        plusButton.setPrefSize(30,30);
        Label iloscLabel = new Label("1");
        iloscLabel.setPadding(new Insets(0,10,0,10));

        Button okButton = new Button("Ok");
        Button anulujButton = new Button("Anuluj");

        Pane pane = new Pane();   // wypełnienie - puste pole
        pane.setPrefWidth(50);

        GridPane gridPane = new GridPane();
        gridPane.add(minusButton, 0,0); // 1 kolumna, 1 wiersz
        gridPane.add(iloscLabel, 1,0); // 2 kolumna, 1 wiersz
        gridPane.add(plusButton, 2, 0); // 3 kolumna, 1 wiersz
        gridPane.add(pane, 3,1); // 4 kolumna, 2 wiersz
        gridPane.add(okButton, 4,1); // 5 kolumna, 2 wiersz
        gridPane.add(anulujButton, 5,1); // 6 kolumna, 2 wiersz


        // ScrollPane ===========================================
        // ScrollPane - siatka
        for (int i = 0; i < 100; i++) {
            ImageView kopiaImageView = new ImageView(new Image("obrazki/pizza/house.png"));
            flowPane.getChildren().add(kopiaImageView);
        }
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(flowPane); // do scroll-a dodany flowPane
        scrollPane.setMaxWidth(60);



        // BorderPane - ===========================================
        BorderPane borderPane = new BorderPane(); // element layoutu
        borderPane.setTop(hBox); // na góre wrzucam hbox-a
        borderPane.setLeft(vBox);
        borderPane.setCenter(stackPane);
        borderPane.setRight(scrollPane);  // do border pane dodano scroll Pane
        borderPane.setBottom(gridPane);


//        TextField textFieldTop = new TextField("Gora");
//        borderPane.setTop(textFieldTop); // ustawiamy na gorze
//        TextField textFieldBottom = new TextField("Dol");
//        borderPane.setBottom(textFieldBottom);
//        TextField textFieldCenter = new TextField("Srodek");
//        borderPane.setCenter(textFieldCenter);
//        TextField textFieldleft = new TextField("Lewy");
//        borderPane.setLeft(textFieldleft);
//        TextField textFieldRight = new TextField("Prawy");
//        borderPane.setRight(textFieldRight);





        Scene scene = new Scene(borderPane, 800, 640 ); // teraz root-em w naszzej scenie jest borderPane

        primaryStage.setScene(scene);
        primaryStage.setTitle("Uklad elementow w widoku");
        primaryStage.show();

    }
}
