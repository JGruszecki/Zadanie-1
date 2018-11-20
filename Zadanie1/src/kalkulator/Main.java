package kalkulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Klasa Main, rozszerzajaca klase Appplication, zawierajaca metode start programu
 * @author Kuba
 *
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
        primaryStage.setScene(new Scene(root, 520, 480));
        primaryStage.setMinHeight(520);
        primaryStage.setMinWidth(540);
        primaryStage.setMaxHeight(520);
        primaryStage.setMaxWidth(540);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}