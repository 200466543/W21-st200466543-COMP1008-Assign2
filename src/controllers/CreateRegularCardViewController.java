package controllers;

import Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import models.Card;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CreateRegularCardViewController {

    FileChooser fc = new FileChooser();

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

    @FXML
    private Button uploadButton;



    /**
     * If the fields are populated, then makes a card object
     * and adds it to the Arraylist
     * @param event
     */
    @FXML
    void createRegularCard(ActionEvent event) {
        if (fieldsArePopulated()) {
            try {
                Card newRegularCard = new Card(cardNameTextField.getText(), Integer.parseInt(manaCostTextField.getText()),
                        typeLineTextField.getText(), textBoxField.getText(), imageView.getImage());
                CreatedCardsViewController.cardsArrayList.add(newRegularCard);
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

    /**
     * Allows user to upload an image, see it
     * and is saved as part of the Card object
     * @param event
     */
    @FXML
    void uploadImageButton(ActionEvent event) {
        fc = new FileChooser();
        File tmp = fc.showOpenDialog(uploadButton.getScene().getWindow());
        System.out.println(tmp.toURI().toString());
        Image img = new Image(tmp.toURI().toString());
        imageView.setImage(img);
    }
}
