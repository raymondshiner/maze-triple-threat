package Tests;

import maze.Maze;
import maze.Room;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MazeTests {
    public MazeTests() {    }



    @ParameterizedTest
    @CsvSource({"-1,1", "1,-1", "0,1", "1,0"})
    public void mazeExplicitConstructor_BadParameters_ThrowsIllegalArgumentException(int rows, int cols)
    {
        assertThrows(IllegalArgumentException.class, () -> {
            Maze maze = new Maze(rows, cols);
        });
    }

    //buildMaze tested via constructor
    @Test
    public void buildMaze_defaultMazeConstructor_CurrentRoomPositionIs0And0()
    {
        Maze maze = new Maze();
        Room room = maze.getCurrentRoom();
        boolean startingRoom = (room.getRowLocation() == 0) && (room.getColLocation() == 0);

        assertEquals(startingRoom, true);
    }

    @Test
    public void buildMaze_defaultMazeConstructor_BottomRightRoomIsExit()
    {
        Maze maze = new Maze();

        while(!maze.getCurrentRoom().getEastBarrier().isAWall())
            maze.movePlayerOneSpace("east");

        while(!maze.getCurrentRoom().getSouthBarrier().isAWall())
            maze.movePlayerOneSpace("south");

        Room room = maze.getCurrentRoom();
        assertEquals(room.isTheExit(), true);
    }

    @Test
    public void defaultMazeConstructor_5by5Maze_BottomRightRoomPositionIs4And4()
    {
        Maze maze = new Maze();

        while(!maze.getCurrentRoom().getEastBarrier().isAWall())
            maze.movePlayerOneSpace("east");

        while(!maze.getCurrentRoom().getSouthBarrier().isAWall())
            maze.movePlayerOneSpace("south");

        Room room = maze.getCurrentRoom();
        boolean lastRoomInRightPlace = room.getRowLocation() == 4 && room.getColLocation() == 4;

        assertEquals(lastRoomInRightPlace, true);
    }

    @Test
    public void movePlayerOneSpace_MoveSouth_CurrentRoomPositionIs1And0()
    {
        Maze maze = new Maze();
        maze.movePlayerOneSpace("south");
        Room room = maze.getCurrentRoom();
        boolean correctRoom = (room.getRowLocation() == 1) && (room.getColLocation() == 0);

        assertEquals(correctRoom, true);
    }

    @Test
    public void movePlayerOneSpace_MoveSouthSouthSouth_CurrentRoomPositionIs3And0()
    {
        Maze maze = new Maze();
        maze.movePlayerOneSpace("south");
        maze.movePlayerOneSpace("south");
        maze.movePlayerOneSpace("south");
        Room room = maze.getCurrentRoom();
        boolean correctRoom = (room.getRowLocation() == 3) && (room.getColLocation() == 0);

        assertEquals(correctRoom, true);
    }

    @Test
    public void getMazeLayout_Valid_ReturnsExpectedString(){
        Maze maze = new Maze();
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
