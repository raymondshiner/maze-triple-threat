package Tests;

import game.Player;
import maze.Maze;
import maze.Room;
import maze.barrier.Door;
import maze.barrier.Wall;
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

    @Test
    public void defaultMazeConstructor_5by5Maze_BottomRightRoomPositionIs4And4()
    {
        Maze maze = new Maze();

        Room room = getLastRoom(maze);

        boolean lastRoomInRightPlace = room.getRowLocation() == 4 && room.getColLocation() == 4;

        assertEquals(lastRoomInRightPlace, true);
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
    public void buildMaze_ExplicitConstructor3by5_BottomRightRoomPositionIs2And4()
    {
        Maze maze = new Maze(3,5);
        Room room = getLastRoom(maze);

        boolean correctRoom = (room.getRowLocation() == 2) && (room.getColLocation() == 4);

        assertEquals(correctRoom, true);
    }

    @Test
    public void buildMaze_ExplicitConstructor3by5_BottomRightRoomIsExit()
    {
        Maze maze = new Maze(3,5);
        Room room = getLastRoom(maze);
        assertEquals(room.isTheExit(), true);
    }

    @Test
    public void answerDoorQuestionCorrectly()
    {
        //do this after merge from Spencer
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

    @Test
    public void lockCurrentRoomsDoor_DefaultDoor_DoorIsLocked()
    {

        Maze m = new Maze();
        Room room = m.getCurrentRoom();
        Door door = (Door)room.getSouthBarrier();

        assertEquals(false, door.isLocked());

        m.lockCurrentRoomsDoor("south");

        assertEquals(true, door.isLocked());
    }

    @Test
    public void lockCurrentRoomsDoor_BadInput_DoorsDoNotChange()
    {

        Maze m = new Maze();
        Room room = m.getCurrentRoom();
        Door south = (Door)room.getSouthBarrier();
        Door east = (Door)room.getEastBarrier();

        boolean bothDoorsUnlocked = !south.isLocked() && !east.isLocked();

        assertEquals(true, bothDoorsUnlocked);

        m.lockCurrentRoomsDoor("badInput");

        boolean bothDoorsStillUnlocked = !south.isLocked() && !east.isLocked();

        assertEquals(true, bothDoorsStillUnlocked);
    }

    @Test
    public void canMoveThroughBarrier_UnlockedDoor_ReturnsTrue()
    {
        Door door = new Door();
        Maze m = new Maze();
        boolean res = m.canMoveThroughBarrier(door);

        assertEquals(true, res);
    }

    @Test
    public void canMoveThroughBarrier_LockedDoor_ReturnsFalse()
    {
        Door door = new Door();
        Maze m = new Maze();
        door.lock();
        boolean res = m.canMoveThroughBarrier(door);

        assertEquals(false, res);
    }

    @Test
    public void canMoveThroughBarrier_Wall_ReturnsFalse()
    {
        Wall wall = new Wall();
        Maze m = new Maze();
        boolean res = m.canMoveThroughBarrier(wall);

        assertEquals(false, res);
    }

    @Test
    public void canSolve_StartingMaze_ReturnsTrue()
    {
        Maze maze = new Maze();
        assertEquals(true, maze.canSolve());
    }

    @Test
    public void canSolve_LockedMazeStartingRoom_ReturnsFalse()
    {
        Maze maze = new Maze();
        Door east = (Door)maze.getCurrentRoom().getEastBarrier();
        Door south = (Door)maze.getCurrentRoom().getSouthBarrier();

        east.lock();
        south.lock();

        assertEquals(false, maze.canSolve());
    }

    @Test
    public void canSolve_DefaultMazeFirstTwoRoomsLocked_ReturnsFalse()
    {
        Maze maze = new Maze();
        Door southStartingRoom = (Door)maze.getCurrentRoom().getSouthBarrier();

        maze.movePlayerOneSpace("east");

        Door southSecondRoom = (Door)maze.getCurrentRoom().getSouthBarrier();
        Door eastSecondRoom = (Door)maze.getCurrentRoom().getEastBarrier();

        assertEquals(true, maze.canSolve());

        southStartingRoom.lock();
        assertEquals(true, maze.canSolve());

        southSecondRoom.lock();
        assertEquals(true, maze.canSolve());

        eastSecondRoom.lock();
        assertEquals(false, maze.canSolve());
    }

    @Test
    public void canSolve_1x8Maze_ReturnsTrue()
    {
        Maze maze = new Maze(1, 8);
        assertEquals(true, maze.canSolve());
    }

    @Test
    public void canSolve_1x8MazeStartingDoorLocked_ReturnsFalse()
    {
        Maze maze = new Maze(1, 8);
        Door east = (Door)maze.getCurrentRoom().getEastBarrier();
        east.lock();

        assertEquals(false, maze.canSolve());
    }

    @Test
    public void getPlayer_DefaultMazeConstructor_PlayerIsNull()
    {
        Maze maze = new Maze();

        Player player = maze.getPlayer();

        boolean playerIsNull = player == null;

        assertEquals(true, playerIsNull);
    }

    @Test
    public void getPlayer_SetPlayerObject_PlayerObjectIsReturned()
    {
        Maze maze = new Maze();

        Player playerA = new Player();

        maze.setPlayer(playerA);

        Player playerB = maze.getPlayer();

        assertEquals(playerA, playerB);
    }

    @Test
    public void setPlayer_ValidPlayerObject_PlayerIsAssigned()
    {
        Maze maze = new Maze();

        Player player = maze.getPlayer();

        boolean playerIsNull = player == null;

        assertEquals(true, playerIsNull);

        Player otherPlayer = new Player();

        maze.setPlayer(otherPlayer);

        assertEquals(otherPlayer, maze.getPlayer());
    }

    @Test
    public void toString_DefaultConstructor_ReturnsExpectedString()
    {
        Maze m = new Maze();
        String expected = "this is a drawing of a fancy maze in ascii art \n ....... why dont you believe me?????";

        assertEquals(expected, m.toString());
    }

    private Room getLastRoom(Maze maze)
    {
        while(!maze.getCurrentRoom().getEastBarrier().isAWall())
            maze.movePlayerOneSpace("east");

        while(!maze.getCurrentRoom().getSouthBarrier().isAWall())
            maze.movePlayerOneSpace("south");

        return maze.getCurrentRoom();
    }



}
