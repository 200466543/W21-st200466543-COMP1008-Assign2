package Utilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    /**
     * This method is for reusing the scene changing code, so you don't
     * have to copy/paste it again and again
     * @param event
     * @param pathToFXML
     * @param title
     * @throws IOException
     */
    public static void changeScenes(ActionEvent event, String pathToFXML, String title ) throws IOException {
        Parent root = FXMLLoader.load(SceneChanger.class.getResource(pathToFXML));
        Scene scene = new Scene(root);

        //get the stage from the event that was passed in
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
