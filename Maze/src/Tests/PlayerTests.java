package Tests;

import game.Player;
import org.junit.jupiter.api.Test;
import questions.implementations.ShortAnswer;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {
    @Test
    public void constructor_NoInputRequired_returnsObject(){
        assertNotNull(new Player());
    }
    @Test
    public void constructor_NoInputRequired_returnsValidPlayer(){
        assertTrue(new Player() instanceof Player);
    }
    @Test
    public void setName_ValidStringCheckedWithGetName_returnsValidString(){
        Player t = new Player();
        t.setName("validString");
        assertTrue(t.getName() instanceof String);
    }
    @Test
    public void setName_ValidStringCheckedWithGetName_returnsValidAndCorrectString(){
        Player t = new Player();
        t.setName("validString");
        assertEquals(t.getName() , "validString");
    }
    @Test
    public void setName_NullInput_ThrowsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Player t = new Player();
            t.setName(null);
        });
    }
    @Test
    public void setName_EmptyInput_ThrowsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Player t = new Player();
            t.setName(null);
        });
    }

}
