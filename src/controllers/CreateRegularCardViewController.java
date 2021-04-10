package controllers;

import Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import models.Card;

import java.io.IOException;
import java.util.ArrayList;

public class CreateRegularCardViewController {

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
    private Label msgLabel;

    //list to store created cards
    ArrayList<Card> regularCardsArrayList = new ArrayList<Card>();

    @FXML
    void createRegularCard(ActionEvent event) {
        if (fieldsArePopulated()) {
            try {
                Card newRegularCard = new Card(cardNameTextField.getText(), Integer.parseInt(manaCostTextField.getText()),
                        typeLineTextField.getText(), textBoxField.getText(), imageView.getImage());
                regularCardsArrayList.add(newRegularCard);
            }catch(IllegalArgumentException e){
                msgLabel.setText(e.getMessage());
            }

        }
    }

    @FXML
    void startMenuButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/cardView.fxml","MTG Card Creator");
    }

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
}
