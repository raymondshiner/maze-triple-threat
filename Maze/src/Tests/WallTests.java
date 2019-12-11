package Tests;

import maze.barrier.IBarrier;
import maze.barrier.Wall;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WallTests {
    @Test
    public void constructor_noInputRequired_returnsValidObject(){
        assertNotNull(new Wall());
    }
    @Test
    public void constructor_noInputRequired_returnsValidWall(){
        assertTrue(new Wall() instanceof Wall);
    }
    @Test
    public void constructor_noInputRequired_returnsValidIBarrier(){
        assertTrue(new Wall() instanceof IBarrier);
    }
    @Test
    public void isAWall_noInputRequired_returnsTrue(){
        assertTrue(new Wall().isAWall());
    }

}
