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

        // Label - nazwa kontrolki  ========================================
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

        // pobranie treście z pola PasswordField
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
        radioButton1.setLayoutY(40);
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






        ////////////////////////////////////////////////
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

        Scene scene = new Scene(group, 800, 600, Color.ANTIQUEWHITE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplikacja kontrolki");
        primaryStage.show();

    }
}
