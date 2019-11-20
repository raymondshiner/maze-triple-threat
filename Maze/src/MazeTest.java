import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {
    public MazeTest() {

    }
    @Test
    public void thisIsATestTest(){
        assertEquals(1,1);
    }



    @Test
    public void displayMaze_ValidOutput_ObjectInstantiated(){
        Maze maze = new Maze();
        String expected = "P: Player\nE: Exit\n************\n" +
                "*P|| || || *\n" +
                "*-**-**-**-*\n" +
                "*-**-**-**-*\n" +
                "* || || || *\n" +
                "*-**-**-**-*\n" +
                "*-**-**-**-*\n" +
                "* || || || *\n" +
                "*-**-**-**-*\n" +
                "*-**-**-**-*\n" +
                "* || || ||E|\n" +
                "************\n";
        assertEquals(expected, maze.displayMaze());
    }
}