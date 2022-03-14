import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;

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

        // Label - nazwa dla kontrolki  ========================================
        Label label = new Label("Moja pierwsza labelka");
        label.setLayoutX(10);
        label.setLayoutX(35);
//        label.setFont(new Font(20));
        label.setFont(font);
//        label.setTextFill(Color.RED); // kolor z palety
        label.setTextFill(color); // kolor własny dedykowany
        label.setMaxWidth(80);
        label.setWrapText(true);
//        label.setRotate(15); // obrocenie tekstu

        // ImageView - ======================================================
        Image image = new Image("email.jpg");
        ImageView imageView = new ImageView(image);
//        label.setGraphic(imageView); // jesli label tu - to wyłącz w group.getChildren().add(imageView);
//        Label labelWithImage = new Label("Labelka z obrazkiem", imageView);
        imageView.setX(110);
        imageView.setY(22);
        imageView.setFitHeight(100);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true); // równomierne rozciąganie obrazka

        // Button - ===================================================
        Button button = new Button("Mój pierwszy przycisk");
        button.setText("Przycisk - text zmieniony");
        button.setLayoutX(20);
        button.setLayoutY(100);
        button.setTextFill(Color.GREEN);
//        button.setGraphic(imageView);
//        button.setDisable(true); // właczanie przycisku
        button.setMaxWidth(500);
        button.setWrapText(true);

        // reakcja po kliknięciu w button
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Kliknales button");
                String tekst = button.getText() + " kliknalem";
                button.setText(tekst);
                button.setDisable(true);
            }
        });

        // TextField - ===================================================
        TextField textField = new TextField();
//        textField.setText("nowy tekst");
        textField.setPromptText("Wpisz email");
        textField.setPrefColumnCount(20);
        textField.setLayoutX(20);
        textField.setLayoutY(140);


        // PaswordField - ===================================================
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Wpisz haslo");
        passwordField.setPrefColumnCount(20); // max. 20 znaków
        passwordField.setLayoutX(20);
        passwordField.setLayoutY(180);

        // pobranie treści z pola PasswordField
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Wpisałes w PaswordField: ");
                String tekst = passwordField.getText();
                System.out.println(tekst);
            }
        });

        // TextArea - ===================================================
        TextArea textArea = new TextArea();
        textArea.setPromptText("textarea");
        textArea.setLayoutX(20);
        textArea.setLayoutY(210);
        textArea.setMaxWidth(200);

        // Checkbox - ===================================================
        CheckBox checkBox = new CheckBox("Nacisnij checkobx");
//        checkBox.setText("Nacisnij checkobx"); // opcjonalnie
        checkBox.setLayoutX(300);
        checkBox.setLayoutY(20);
        checkBox.setSelected(true); // domyslnie zaznaczony
        checkBox.isSelected(); // metoda sprawdza czy checkbox zaznaczony


        // radioButton - ===================================================
        RadioButton radioButton1 = new RadioButton("Radiobutton 1");
        RadioButton radioButton2 = new RadioButton("Radiobutton 2");

        radioButton1.setLayoutX(300);
        radioButton1.setLayoutY(45);
//        radioButton1.setSelected(true); // stale zaznaczony
//        radioButton1.isSelected(); - czy jest zaznaczony

        radioButton2.setLayoutX(300);
        radioButton2.setLayoutY(70);

        // radioButton - ustawiamy grupe dla Radio Buttonow
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

        // radioButton - nasluchiwanie
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton wybrany = (RadioButton) newValue;
                System.out.println("Wybrany: " + wybrany.getText());
            }
        });

        // ChoiceBox - rozwijany- =================================================
        String[] listaWyborow = {"Pierwszy ChoiceBox", "Drugi ChoiceBox", "Trzeci ChoiceBox", "Czwarty ChoiceBox"};

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setLayoutX(300);
        choiceBox.setLayoutY(100);
        choiceBox.getItems().addAll(listaWyborow);

        // nasłuciwanie ChoiceBox
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String wybor = listaWyborow[newValue.intValue()];
                System.out.println("Wybor z choiceBox: " + wybor);
            }
        });


        // ListView - =================================================
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(listaWyborow); // dodanie listy do naszego listView
        listView.setLayoutX(300);
        listView.setLayoutY(130);
        listView.setMaxHeight(200);
        listView.setMaxHeight(100);
        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String wybor = listaWyborow[newValue.intValue()]; // odwolujemy sie do indeksu
                System.out.println("Wybrany z listView: " + wybor);
            }
        });


        // ProgressBar - =================================================
        ProgressBar progressBar = new ProgressBar();
        progressBar.setLayoutX(300);
        progressBar.setLayoutY(230);
        progressBar.setProgress(0.7); // ustawianie progresu


        // ProgressIndicator - =================================================
        ProgressIndicator progressIndicator = new ProgressIndicator();
//        ProgressIndicator progressIndicator = new ProgressIndicator(0.9); // stan ustawiony w konstruktorze
        progressIndicator.setLayoutX(300);
        progressIndicator.setLayoutY(250);
        progressIndicator.setProgress(0.3);

        // Slider - =================================================
        Slider slider = new Slider(0,100, 0);
        slider.setLayoutX(300);
        slider.setLayoutY(300);
        slider.setPrefWidth(200);
//        slider.setMin(0); // wartosc ustawione w konstruktorze
//        slider.setMax(100);
//        slider.setValue(10);
        slider.setShowTickMarks(true); // podziałka
        slider.setShowTickLabels(true); // wartosci na podzialce
        slider.setMajorTickUnit(25); // wartosci co jaka wartosc
        slider.setMinorTickCount(4); // odleglosc miedzy tickami-podziałkami
        slider.setSnapToTicks(true); // przy przesuwaniu slider "wpada" w ticki

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Slider: " + newValue.intValue());
                if(newValue.intValue() == 100) {
                    progressBar.setVisible(false);  // Chowanie kontrolek
                    progressIndicator.setVisible(false);  // Chowanie kontrolek
                } else {
                    double valuePercent = newValue.doubleValue() / 100.0;
                    progressBar.setProgress(valuePercent);
                    progressIndicator.setProgress(valuePercent);
                    progressBar.setVisible(true);  // Pokazanie kontrolek
                    progressIndicator.setVisible(true);  // Pokazanie kontrolek
                }
            }
        });




        ////////////////////////////////////////////////
        // Group - grupowanie widoku
        Group group = new Group();
        group.getChildren().add(label);
        group.getChildren().add(imageView);
//        group.getChildren().add(labelWithImage);
        group.getChildren().add(button);
        group.getChildren().add(textField);
        group.getChildren().add(passwordField);
        group.getChildren().add(textArea);
        group.getChildren().add(checkBox);
        group.getChildren().add(radioButton1);
        group.getChildren().add(radioButton2);
        group.getChildren().add(choiceBox);
        group.getChildren().add(listView);
        group.getChildren().add(progressBar);
        group.getChildren().add(progressIndicator);
        group.getChildren().add(slider);

        Scene scene = new Scene(group, 800, 600, Color.ANTIQUEWHITE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplikacja kontrolki");
        primaryStage.show();

    }
}
