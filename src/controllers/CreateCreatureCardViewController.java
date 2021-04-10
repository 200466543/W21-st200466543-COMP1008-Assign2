package controllers;

import Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import models.Card;
import models.Creature;

import java.io.IOException;

public class CreateCreatureCardViewController {

    @FXML
    private TextField cardNameTextField;

    @FXML
    private TextField manaCostTextField;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField typeLineTextField;

    @FXML
    private TextArea textBoxField;

    @FXML
    private TextField powerTextField;

    @FXML
    private TextField toughnessTextField;

    @FXML
    private Label msgLabel;

    @FXML
    private Button uploadButton;

    /**
     * If the fields are populated, then makes a creature object
     * and adds it to the Arraylist
     * @param event
     */
    @FXML
    void createCreatureCard(ActionEvent event) {
        if (fieldsArePopulated()) {
            try {
                Creature newCreatureCard = new Creature(cardNameTextField.getText(), Integer.parseInt(manaCostTextField.getText()),
                        typeLineTextField.getText(), textBoxField.getText(), imageView.getImage(), Integer.parseInt(powerTextField.getText()),
                        Integer.parseInt(toughnessTextField.getText()));
                CreatedCardsViewController.cardsArrayList.add(newCreatureCard);
            }catch(IllegalArgumentException e){
                msgLabel.setText(e.getMessage());
            }

        }
    }

    /**
     * Returns user to start menu
     * @param event
     * @throws IOException
     */
    @FXML
    void startMenuButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/cardView.fxml","MTG Card Creator");
    }


    /**
     * Checks to see if all fields are populated, except image
     * as some cards don't have an image
     * @return
     */
    private boolean fieldsArePopulated()
    {
        String errMsg = "The following fields are empty: ";
        if (cardNameTextField.getText().isEmpty())
            errMsg += "card name, ";

        if (manaCostTextField.getText().isEmpty())
            errMsg += "mana cost, ";

        if (typeLineTextField.getText().isEmpty())
            errMsg += "type line, ";

        if (textBoxField.getText().isEmpty())
            errMsg += "text box, ";

        if (errMsg.equals("The following fields are empty: "))
            return true;

        //there was at least 1 empty field
        msgLabel.setText(errMsg.substring(0, errMsg.length()-2));
        return false;
    }

    @FXML
    void uploadImageButton(ActionEvent event) {

    }
}
