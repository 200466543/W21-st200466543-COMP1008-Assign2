package controllers;

        import Utilities.SceneChanger;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextArea;
        import javafx.scene.control.TextField;
        import javafx.scene.image.ImageView;

        import java.io.IOException;

public class CreatedCardsViewController {

    @FXML
    private TextArea listOfCards;

    @FXML
    private TextField cardNameTextField;

    @FXML
    private Label cardNameLabel;

    @FXML
    private Label manaCostLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label typeLineLabel;

    @FXML
    private TextArea textBoxField;

    @FXML
    void selectCardButton(ActionEvent event) {

    }

    @FXML
    void startMenuButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/cardView.fxml","MTG Card Creator");
    }

}
