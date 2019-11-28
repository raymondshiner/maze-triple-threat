public class Maze {
    private Room [][] rooms;
    private Player player;
    private int playerRow;
    private int playerCol;
    private Room currentRoom;

    public Maze(Player thePlayer){

        if(thePlayer == null)
            throw new IllegalArgumentException("Maze Constructor player is null");

        buildMaze(thePlayer);
    }

    private void buildMaze(Player thePlayer){
        rooms = new Room[5][5];
        player = thePlayer;
        playerRow = 0;
        playerCol = 0;

        for(int x = 0; x < 5; x++)
        {
            for(int y = 0; y<5; y++)
            {
                Room room = new Room(); //Room by default is all doors

                if(x == 0) //first row of maze
                    room.setNorthBarrier(new Wall());

                if(x == 4)
                    room.setSouthBarrier(new Wall());

                if(y == 0) //first column of maze
                    room.setWestBarrier(new Wall());

                if(y == 4) //last column of maze
                    room.setEastBarrier(new Wall());

                rooms[x][y] = room;
            }
        }

        currentRoom = rooms[playerRow][playerCol];
    }

    public boolean move(String direction)
    {
        direction = direction.toLowerCase().trim();

        IBarrier barrier;

        switch(direction)
        {
            case "north":
                barrier = currentRoom.getNorthBarrier();
                break;
            case "south":
                barrier = currentRoom.getSouthBarrier();
                break;
            case "east":
                barrier = currentRoom.getEastBarrier();
                break;
            case "west":
                barrier = currentRoom.getWestBarrier();
                break;
            default:
                throw new IllegalArgumentException("Only Move North South East West");
        }

        if(canMoveThroughBarrier(barrier))
        {
            movePlayerOneSpace(direction);
            return true;
        }

        System.out.println();
        return  false;
    }

    private void movePlayerOneSpace(String direction) {

        System.out.println("You Walk through the " + direction + " door");

        Door door;
        Door otherSideOfDoor;

        switch(direction)
        {
            case "north":
                door = (Door)currentRoom.getNorthBarrier();
                playerRow--;
                otherSideOfDoor = (Door)rooms[playerRow][playerCol].getSouthBarrier();
                break;
            case "south":
                door = (Door)currentRoom.getSouthBarrier();
                playerRow++;
                otherSideOfDoor = (Door)rooms[playerRow][playerCol].getNorthBarrier();
                break;
            case "east":
                door = (Door)currentRoom.getEastBarrier();
                playerCol++;
                otherSideOfDoor = (Door)rooms[playerRow][playerCol].getWestBarrier();
                break;
            case "west":
                door = (Door)currentRoom.getWestBarrier();
                playerCol--;
                otherSideOfDoor = (Door)rooms[playerRow][playerCol].getEastBarrier();
                break;
            default:
                throw new IllegalArgumentException("movePlayerOneSpace not valid direction");
        }

        door.open();
        otherSideOfDoor.open();

        currentRoom = rooms[playerRow][playerCol];
    }

    private boolean canMoveThroughBarrier(IBarrier barrier)
    {
        boolean canMove = true;

        if(barrier.isAWall())
        {
            System.out.println("You tried walking into a wall - nice move");
            canMove = false;
        }

        else
        {
            Door door = (Door)barrier;

            if(door.isLocked())
            {
                System.out.println("That door is locked");
                canMove = false;
            }
        }

        return canMove;
    }

    private boolean canSolve(){
        // called after every failed trivia question
        return false;
    }

    public void printCurrentRoom()
    {
        rooms[playerRow][playerCol].displayRoom();
    }

    @Override
    public String toString(){
        return "this is a drawing of a fancy maze in ascii art \n ....... why dont you believe me?????";
    }

    public String getMazeLayout(){
        String s = "P: Player\nE: Exit";
        return(s + "\n***************\n" +
                "*P|| || || || *\n" +
                "*-**-**-**-**-*\n" +
                "*-**-**-**-**-*\n" +
                "* || || || || *\n" +
                "*-**-**-**-**-*\n" +
                "*-**-**-**-**-*\n" +
                "* || || || || *\n" +
                "*-**-**-**-**-*\n" +
                "*-**-**-**-**-*\n" +
                "* || || || ||E|\n" +
                "***************\n");
    }
}
