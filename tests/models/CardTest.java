package models;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    Card card;
    JFXPanel panel = new JFXPanel();

    @BeforeEach
    void setUp(){
        card = new Card("Negate", 2, "Instant",
                "Counter target noncreature spell.", new Image("images/negate.jpg"));
    }

    @Test
    void setName() {
        card.setName("Counterspell");
        assertEquals("Counterspell", card.getName());
    }

    @Test
    void setNameInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                card.setName(""));
    }

    @Test
    void setManaCost() {
        card.setManaCost(5);
        assertEquals(5, card.getManaCost());
    }

    @Test
    void setManaCostInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                card.setManaCost(0));
    }

    @Test
    void setTypeLine() {
        card.setTypeLine("Interrupt");
        assertEquals("Interrupt", card.getTypeLine());
    }

    @Test
    void setTypeLineInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                card.setTypeLine(""));
    }

    @Test
    void setTextBox() {
        card.setTextBox("Counter target spell.");
        assertEquals("Counter target spell.", card.getTextBox());
    }

    //I don't think we are testing images in this course, also I don't know how to
    @Test
    void setCardImage() {
    }

    @Test
    void testToString() {
        String expected = "Negate has mana cost of 2 and is" +
                " type Instant with textbox Counter target noncreature spell.";
        assertEquals(expected, card.toString());
    }
}