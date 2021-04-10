package controllers;

        import Utilities.SceneChanger;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextArea;
        import javafx.scene.control.TextField;
        import javafx.scene.image.ImageView;
        import models.Card;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.ResourceBundle;

public class CreatedCardsViewController implements Initializable {

    //list to store created card
    public static ArrayList<Card> cardsArrayList = new ArrayList<Card>();

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
        String targetCard = cardNameTextField.getText();
        List<Card> madeCards = cardsArrayList;
        for (Card card : madeCards){
            if (card.getName().equals(targetCard)){
                cardNameLabel.setText(card.getName());
                manaCostLabel.setText(Integer.toString(card.getManaCost()));
                imageView.setImage(card.getCardImage());
                typeLineLabel.setText(card.getTypeLine());
                textBoxField.setText(card.getTextBox());
            }
        }
    }

    @FXML
    void startMenuButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/cardView.fxml","MTG Card Creator");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Card> madeCards = cardsArrayList;
        String text = "";
        for (Card card: madeCards) {
            text = text + card.getName() + "\n";
        }
        listOfCards.setText(text);
    }
}
