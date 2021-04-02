package models;

import javafx.scene.image.Image;

public class Creature extends Card{

    private int power;
    private int toughness;

    public Creature(String name, int manaCost, String typeLine,
                    String textBox, Image cardImage, int power, int toughness) {
        super(name, manaCost, typeLine, textBox, cardImage);
        setPower(power);
        setToughness(toughness);
    }

    public int getPower() {
        return power;
    }

    public int getToughness() {
        return toughness;
    }

    /**
     * Checks to make sure power is actually inputted,
     * and creatures can have a power of 0
     * @param power
     */
    public void setPower(int power) {
        if (power >= 0){
            this.power = power;
        } else {
            throw new IllegalArgumentException("Please enter a power");
        }
    }

    /**
     * Checks to make sure toughness is actually inputted,
     * toughness must be at least 1
     * @param toughness
     */
    public void setToughness(int toughness) {
        if (toughness >= 1){
            this.toughness = toughness;
        } else {
            throw new IllegalArgumentException("Please enter a power");
        }
    }
}
