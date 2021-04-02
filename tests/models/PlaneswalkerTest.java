package models;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneswalkerTest {

    Planeswalker planeswalker;
    JFXPanel panel = new JFXPanel();

    @BeforeEach
    void setUp() {
        planeswalker = new Planeswalker("Davriel, Rogue Shadowmage", 3, "Legendary Planeswalker",
                "At the beginning of each opponent's upkeep, if that player has one or fewer cards in hand, Davriel, Rogue Shadowmage deals 2 damage to them. -1 Target Player discards a card",
                new Image("images/davriel.jpg"), 3);
    }

    @Test
    void setLoyalty() {
        planeswalker.setLoyalty(5);
        assertEquals(5, planeswalker.getLoyalty());
    }

    @Test
    void setLoyaltyInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                planeswalker.setLoyalty(0));
    }
}