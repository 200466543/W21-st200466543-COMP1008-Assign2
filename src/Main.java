import Utilities.SceneChanger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Card;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/cardView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("MTG Card Creator");
        stage.show();
    }

}
