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
    public void constructor_NullPlayerParamter_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            Maze maze = new Maze(1, 1);
        });
    }



    @Test
    public void displayMaze_InstatiateObject_ReturnsExpectedOutput(){
        Maze maze = new Maze(1, 1);
        String expected = "P: Player\nE: Exit\n" +
                        "***********\n" +
                        "*P| | | | *\n" +
                        "*-*-*-*-*-*\n" +
                        "* | | | | *\n" +
                        "*-*-*-*-*-*\n" +
                        "* | | | | *\n" +
                        "*-*-*-*-*-*\n" +
                        "* | | | |E|\n" +
                        "***********\n";
        assertEquals(expected, maze.getMazeLayout());
    }
}
