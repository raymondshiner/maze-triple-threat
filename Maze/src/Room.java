public class Room {

    private IBarrier northBarrier;
    private IBarrier southBarrier;
    private IBarrier eastBarrier;
    private IBarrier westBarrier;

    public Room()
    {
        northBarrier = new Door();
        southBarrier = new Door();
        eastBarrier = new Door();
        westBarrier = new Door();
    }

    public void setNorthBarrier(IBarrier barrier) { northBarrier = barrier; }
    public void setSouthBarrier(IBarrier barrier) { southBarrier = barrier; }
    public void setEastBarrier(IBarrier barrier) { eastBarrier = barrier; }
    public void setWestBarrier(IBarrier barrier) { westBarrier = barrier; }

    public IBarrier getNorthBarrier() { return northBarrier; }
    public IBarrier getSouthBarrier() { return southBarrier; }
    public IBarrier getEastBarrier() { return eastBarrier; }
    public IBarrier getWestBarrier() { return westBarrier; }


    public void displayRoom()
    {
        String up = "North - " + constructBarrierString(northBarrier);
        String left = "West - " + constructBarrierString(westBarrier);
        String right = "East - " + constructBarrierString(eastBarrier);
        String down = "South - " + constructBarrierString(southBarrier);

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

        if(door.isOpen())
            return str + "(Open)";

        return str + "(Closed)";
    }

}
