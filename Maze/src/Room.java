public class Room {

    private IBarrier northBarrier;
    private IBarrier southBarrier;
    private IBarrier eastBarrier;
    private IBarrier westBarrier;

    public Room(IBarrier north, IBarrier south, IBarrier east, IBarrier west) {

        if (north == null || south == null || east == null || west == null)
            throw new IllegalArgumentException("Cannot have null properties for Room");

        northBarrier = north;
        southBarrier = south;
        eastBarrier = east;
        westBarrier = west;
    }

    public void displayRoom()
    {
        String up = "Up - " + constructBarrierString(northBarrier);
        String left = "Left - " + constructBarrierString(westBarrier);
        String right = "Right - " + constructBarrierString(eastBarrier);
        String down = "Down - " + constructBarrierString(southBarrier);

        System.out.println(up);
        System.out.println(left);
        System.out.println(right);
        System.out.println(down);
    }

    private String constructBarrierString(IBarrier barrier) {
        if(barrier.isAWall())
            return "Wall";

        Door door = (Door)barrier;
        String str = "Door ";

        if(door.isLocked())
            return str + "(Locked)";

        if(door.isClosed())
            return str + "(Closed)";

        return str + "(Open)";
    }

}
