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
        import models.Creature;
        import models.Planeswalker;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.ResourceBundle;

public class CreatedCardsViewController implements Initializable {

    //list to store created card
    public static ArrayList<Card> cardsArrayList = new ArrayList<Card>();
    public static ArrayList<Creature> creaturesArrayList = new ArrayList<Creature>();
    public static ArrayList<Planeswalker> planeswalkersArrayList = new ArrayList<Planeswalker>();

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
    private TextField powerTextField;

    @FXML
    private TextField toughnessTextField;

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
        List<Creature> madeCreatures = creaturesArrayList;
        for (Creature creature: madeCreatures) {
            if (creature.getName().equals(targetCard)){
                cardNameLabel.setText(creature.getName());
                manaCostLabel.setText(Integer.toString(creature.getManaCost()));
                imageView.setImage(creature.getCardImage());
                typeLineLabel.setText(creature.getTypeLine());
                textBoxField.setText(creature.getTextBox());
                powerTextField.setText(Integer.toString(creature.getPower()));
                toughnessTextField.setText(Integer.toString(creature.getToughness()));
            }
        }
        List<Planeswalker> madePlaneswalkers = planeswalkersArrayList;
        for (Planeswalker planeswalker:madePlaneswalkers) {
            if (planeswalker.getName().equals(targetCard)){
                cardNameLabel.setText(planeswalker.getName());
                manaCostLabel.setText(Integer.toString(planeswalker.getManaCost()));
                imageView.setImage(planeswalker.getCardImage());
                typeLineLabel.setText(planeswalker.getTypeLine());
                textBoxField.setText(planeswalker.getTextBox());
                powerTextField.setText(Integer.toString(planeswalker.getLoyalty()));
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

        List<Creature> madeCreatures = creaturesArrayList;
        for (Creature creature: madeCreatures) {
            text = text + creature.getName() + "\n";
        }

        List<Planeswalker> madePlaneswalkers = planeswalkersArrayList;
        for (Planeswalker planeswalker:madePlaneswalkers){
            text = text + planeswalker.getName() + "\n";
        }

        listOfCards.setText(text);
    }
}
