package maze;

import maze.barrier.Door;
import maze.barrier.IBarrier;

import java.io.Serializable;

public class Room implements Serializable {

    private IBarrier northBarrier;
    private IBarrier southBarrier;
    private IBarrier eastBarrier;
    private IBarrier westBarrier;
    private int rowLocation;
    private int colLocation;
    private boolean isTheExit;

    public Room(int row, int col)
    {
        if(row < 0 || col < 0)
            throw new IllegalArgumentException("Room() - row and/or col can't be 0 or less");

        northBarrier = new Door();
        southBarrier = new Door();
        eastBarrier = new Door();
        westBarrier = new Door();
        isTheExit = false;
        rowLocation = row;
        colLocation = col;
    }

    void setNorthBarrier(IBarrier barrier) { northBarrier = barrier; }
    void setSouthBarrier(IBarrier barrier) { southBarrier = barrier; }
    void setEastBarrier(IBarrier barrier) { eastBarrier = barrier; }
    void setWestBarrier(IBarrier barrier) { westBarrier = barrier; }

    public IBarrier getNorthBarrier() { return northBarrier; }
    public IBarrier getSouthBarrier() { return southBarrier; }
    public IBarrier getEastBarrier() { return eastBarrier; }
    public IBarrier getWestBarrier() { return westBarrier; }
    public int getRowLocation() {return rowLocation;}
    public int getColLocation() {return colLocation;}


    void displayRoom(){
        String up = "North - " + constructBarrierString(northBarrier);
        String left = "West - " + constructBarrierString(westBarrier);
        String right = "East - " + constructBarrierString(eastBarrier);
        String down = "South - " + constructBarrierString(southBarrier);

        System.out.println(up);
        System.out.println(left);
        System.out.println(right);
        System.out.println(down);
    }

    public String constructBarrierString(IBarrier barrier) {
        if(barrier.isAWall())
            return "Wall";

        Door door = (Door)barrier;
        String str = "Door ";

        if(door.isLocked())
            return str + "(Locked)";

        if(door.isOpen())
            return str + "(Open)";

        return str + "(Closed)";
    }

    public void makeExit() {
        isTheExit = true;
    }

    public boolean isTheExit() {
        return isTheExit;
    }
}
