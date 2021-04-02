package models;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    Creature creature;
    JFXPanel panel = new JFXPanel();

    @BeforeEach
    void setUp() {
        creature = new Creature("Frilled Mystic", 4, "Creature",
                "Flash When Frilled Mystic enters the battlefield, you may counter target spell.",
                new Image("images/frilledmystic.jpg"), 3, 2);
    }

    @Test
    void setPower() {
        creature.setPower(6);
        assertEquals(6, creature.getPower());
    }

    @Test
    void setPowerInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                creature.setPower(-1));
    }

    @Test
    void setToughness() {
        creature.setToughness(8);
        assertEquals(8, creature.getToughness());
    }

    @Test
    void setToughnessInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                creature.setToughness(0));
    }
}