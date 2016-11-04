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
    Scene menu, game, toplist; // menu and topList reserved for later implementation
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
        ObservableList<String> items = FXCollections.observableArrayList();
        TextField guess = new TextField();
        Button submitGuess = new Button("OK");
        submitGuess.setOnAction(e -> passToLogic(guess.getText(), newGame, guesses, items));
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
    private void passToLogic(String input, Game newGame, ListView<String> guesses, ObservableList<String> items) {

        // -- here we need to implement test whether input is 4 digits or something else... --

        if (input.length() > 4) {
            try {
                throw new IncorrectLengthException("the number u passed in is shorter or longer than 4 characters :@");
            } catch (IncorrectLengthException e) {
                e.printStackTrace();
            }
        }
        List<Integer> inputListNum = new ArrayList<>(4);
        // converting user input to list:
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split("")));
        // convert list items to integer and pass it to Integer list (/@gyuri hates Java):
        for (int i = 0; i<inputList.size(); i++) {
            inputListNum.add(Integer.valueOf(inputList.get(i)));
        }
        formatOutput(newGame.getHelper(inputListNum), input, guesses, items);
    }
    private void formatOutput(List<Integer> helpers, String input, ListView<String> guesses, ObservableList<String> items){
        String output = String.format("%s | %d | %d", input, helpers.get(0), helpers.get(1));
        outputToList(output, guesses, items);
    }
    private void outputToList(String output, ListView<String> guesses, ObservableList<String> items){
        items.addAll(output);
        guesses.setItems(items);
    }
}
