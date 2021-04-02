package models;

import javafx.scene.image.Image;

public class Card {
    private String name;
    private int manaCost;
    private String typeLine;
    private String textBox;
    private Image cardImage;


    /**
     * This constructor takes 5 arguments
     * @param name
     * @param manaCost
     * @param typeLine
     * @param textBox
     * @param cardImage
     */
    public Card(String name, int manaCost, String typeLine, String textBox, Image cardImage) {
        setName(name);
        setManaCost(manaCost);
        setTypeLine(typeLine);
        setTextBox(textBox);
        setCardImage(cardImage);
    }


    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public String getTextBox() {
        return textBox;
    }

    public Image getCardImage() {
        return cardImage;
    }

    /**
     * Checks to make sure name is actually inputted
     * @param name
     */
    public void setName(String name) {
        name = name.trim();
        if (name.length() >= 1){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Please enter a name.");
        }
    }

    /**
     * Checks to make sure manaCost is inputted
     * @param manaCost
     */
    public void setManaCost(int manaCost) {
        if (manaCost >= 1){
            this.manaCost = manaCost;
        } else {
            throw new IllegalArgumentException("Please enter a mana cost");
        }
    }

    /**
     * Checks to make sure spell type is entered
     * @param typeLine
     */
    public void setTypeLine(String typeLine) {
        typeLine = typeLine.trim();
        if (typeLine.length() >= 1){
            this.typeLine = typeLine;
        } else {
            throw new IllegalArgumentException("Please enter a spell type.");
        }
    }

    /**
     * Some cards don't have text in the text box, so no validation is needed
     * @param textBox
     */
    public void setTextBox(String textBox) {
        this.textBox = textBox;
    }

    /**
     * Sets the card image (will probably be reworked once I have the GUI setup,
     * as I may let user upload a image or pick from a few pre-make ones in a list)
     * @param cardImage
     */
    public void setCardImage(Image cardImage) {
        this.cardImage = cardImage;
    }

    public String toString(){
        return String.format("%s has mana cost of %d and is type %s with textbox %s",
                name, manaCost, typeLine, textBox);
    }
}
