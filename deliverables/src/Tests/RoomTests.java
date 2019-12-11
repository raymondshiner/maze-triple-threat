package Tests;

import maze.Room;
import maze.barrier.Door;
import maze.barrier.Wall;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTests {


    @Test
    public void constructor_ValidInput_AllFourDoorsAreInstatiated()
    {
        Room room = new Room(1, 1);
        boolean allFourDoorsGood = (room.getEastBarrier() != null && room.getSouthBarrier() != null && room.getNorthBarrier() != null && room.getWestBarrier() != null);

        assertEquals(true, allFourDoorsGood);
    }

    @Test
    public void constructor_ValidInput_RowAndColLocationAreCorrect()
    {
        Room room = new Room(1, 1);
        boolean rowAndColAreGood = room.getColLocation() == 1 && room.getRowLocation() == 1;

        assertEquals(true, rowAndColAreGood);
    }

    @Test
    public void constructor_ValidInput_RoomIsNotExit()
    {
        Room room = new Room(1, 1);
        assertEquals(false, room.isTheExit());
    }

    @Test
    public void makeExit_ValidState_MakesRoomTheExit()
    {
        Room room = new Room(1, 1);
        assertEquals(false, room.isTheExit());

        room.makeExit();
        assertEquals(true, room.isTheExit());
    }

    @Test
    public void constructBarrierString_InputWall_ReturnsExpectedString()
    {
        Room room = new Room(1, 1);
        String expeceted = "Wall";

        assertEquals(expeceted, room.constructBarrierString(new Wall()));
    }

    @Test
    public void constructBarrierString_InputClosedDoor_ReturnsExpectedString()
    {
        Room room = new Room(1, 1);
        String expeceted = "Door (Closed)";

        assertEquals(expeceted, room.constructBarrierString(new Door()));
    }

    @Test
    public void constructBarrierString_InputOpenDoor_ReturnsExpectedString()
    {
        Room room = new Room(1, 1);
        String expeceted = "Door (Open)";
        Door door = new Door();
        door.open();

        assertEquals(expeceted, room.constructBarrierString(door));
    }

    @Test
    public void constructBarrierString_InputLockedDoor_ReturnsExpectedString()
    {
        Room room = new Room(1, 1);
        String expeceted = "Door (Locked)";
        Door door = new Door();
        door.lock();

        assertEquals(expeceted, room.constructBarrierString(door));
    }
}
