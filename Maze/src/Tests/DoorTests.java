package Tests;

import Tests.mockObjects.TestableQuestion;
import maze.barrier.Door;
import maze.barrier.IBarrier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoorTests {
    @Test
    public void constructor_NoInputRequired_returnsValidObject(){
        assertNotNull(new Door());
    }
    @Test
    public void constructor_NoInputRequired_returnsValidDoor(){
        assertTrue(new Door() instanceof Door);
    }
    @Test
    public void constructor_NoInputRequired_returnsValidIBarrier(){
        assertTrue(new Door() instanceof IBarrier);
    }
    @Test
    public void isAWall_NoInputRequired_returnsFalse(){
        assertFalse(new Door().isAWall());
    }
    @Test
    public void setQuestion_NullInput_throwsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Door t = new Door();
            t.setQuestion(null);
        });
    }
    @Test
    public void getQuestion_ValidInputViaSetQuestion_ReturnsValidTestableQuestion(){
            Door t = new Door();
            t.setQuestion(new TestableQuestion("testQuestion" , "testAnswer"));
            assertTrue(t.getQuestion() instanceof TestableQuestion);

    }
    @Test
    public void isLocked_ValidConstruction_returnsFalse(){
        assertFalse(new Door().isLocked());
    }
    @Test
    public void lock_checkWithIsLocked_returnsTrue(){
        Door t = new Door();
        t.lock();
        assertTrue(t.isLocked());
    }
    @Test
    public void isOpen_ValidConstruction_returnsFalse(){
        assertFalse(new Door().isOpen());
    }
    @Test
    public void open_CheckWithIsOpen_returnsTrue(){
        Door t = new Door();
        t.open();
        assertTrue(t.isOpen());
    }


}
