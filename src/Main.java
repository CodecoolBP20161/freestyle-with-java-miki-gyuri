import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main extends Application {

    Stage window;
    Scene menu, game, toplist;
    List<Integer> results;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        Game newGame = new Game();

        Label gameTitle = new Label("Game");
        ListView<String> guesses = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList ();
        guesses.setItems(items);
        TextField guess = new TextField();
        Button submitGuess = new Button("OK");
        submitGuess.setOnAction(e -> isInt(guess.getText(), items, newGame));
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
    private void isInt(String input, ObservableList<String> items, Game newGame) {
        try {
            List<Integer> tmpList = new ArrayList<>(4);
            int guess = Integer.parseInt(input);
            while (guess > 0) {
                tmpList.add(guess % 10);
                guess /= 10;
            }
            List<Integer> cpTmp = new ArrayList<>(4);
            for (int i = -1; i == -(tmpList.size()); i--) cpTmp.set(i, tmpList.get(i));
            String result = "";
            for (Integer num : cpTmp) {
                result += num;
            }
            tmpList = cpTmp;
            result += ": " + Arrays.toString(newGame.compare(tmpList));
            items.add(result);


        } catch (NumberFormatException e) {
            Alert invalidInput = new Alert(Alert.AlertType.ERROR);
            invalidInput.showAndWait()
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> isInt(input, items, newGame));
        }
    }
}
