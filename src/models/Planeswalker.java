package models;

import javafx.scene.image.Image;

public class Planeswalker extends Card{
    private int loyalty;

    public Planeswalker(String name, int manaCost, String typeLine,
                        String textBox, Image cardImage, int loyalty) {
        super(name, manaCost, typeLine, textBox, cardImage);
        setLoyalty(loyalty);
    }

    public int getLoyalty() {
        return loyalty;
    }

    /**
     * Checks to make sure loyalty is actually inputted
     * @param loyalty
     */
    public void setLoyalty(int loyalty) {
        if (loyalty >= 1){
            this.loyalty = loyalty;
        } else {
            throw new IllegalArgumentException("Please enter a loyalty");
        }

    }
}
