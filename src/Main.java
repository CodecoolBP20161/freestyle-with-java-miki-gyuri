import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    Stage window;
    Scene menu, game, toplist;
    List<String> results;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        Label gameTitle = new Label("Game");
        results = new ArrayList<>();
        ListView<String> guesses = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList (
                "Single", "Double", "Suite", "Family App");
        guesses.setItems(items);
        TextField guess = new TextField();
        Button submitGuess = new Button("OK");
        submitGuess.setOnAction(e -> isInt(guess, guess.getText()));
        HBox userGuess = new HBox(10);
        userGuess.getChildren().addAll(guess, submitGuess);
        userGuess.setAlignment(Pos.TOP_CENTER);
        VBox gameContent = new VBox(10);
        gameContent.getChildren().addAll(gameTitle, guesses, userGuess);
        gameContent.setPadding(new Insets(10, 10, 10, 10));

        game = new Scene(gameContent, 250, 400);

        window.setScene(game);
        window.show();

    }
    boolean isInt () {
        try {
            int guess = guess
        }
    }
}
