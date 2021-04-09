package controllers;

import Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Card;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardViewController implements Initializable {

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

    private Card startCard = new Card("Negate", 2, "Instant",
            "Counter target noncreature spell.", new Image("images/negate.jpg"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cardNameLabel.setText(startCard.getName());
        manaCostLabel.setText(Integer.toString(startCard.getManaCost()));
        imageView.setImage(startCard.getCardImage());
        typeLineLabel.setText(startCard.getTypeLine());
        textBoxField.setText(startCard.getTextBox());
    }

    @FXML
    void createNewCreatureCard(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/createCreatureCardView.fxml","MTG Card Creator - Create a Creature Card");
    }

    @FXML
    void createNewPlaneswalkerCard(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/createPlaneswalkerCardView.fxml","MTG Card Creator - Create a Planeswalker Card");
    }

    @FXML
    void createNewRegularCard(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/createRegularCardView.fxml","MTG Card Creator - Create a Regular Card");
    }
}


