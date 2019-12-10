package maze;

import game.Player;
import maze.barrier.*;
import questions.*;

import java.io.Serializable;
import java.util.Scanner;

public class Maze  implements Serializable {
    private Room[][] rooms;
    private int playerRow;
    private int playerCol;
    private Room currentRoom;
    private Player thePlayer;

    public Maze(int row, int col){

        if(row < 1 || col < 1)
            throw new IllegalArgumentException("Maze Constructor can't have <1 length or depth");

        buildMaze (row, col);
    }

    public Maze()
    {
        buildMaze(5, 5);
    }

    private void buildMaze(int row, int col){
        rooms = new Room[row][col];
        playerRow = 0;
        playerCol = 0;

        QuestionFactory factory = new QuestionFactory();

        for(int x = 0; x < row; x++)
        {
            for(int y = 0; y<col; y++)
            {
                Room room = new Room(x, y); //Room by default is all doors

                Door north = (Door)room.getNorthBarrier();
                Door south = (Door)room.getSouthBarrier();
                Door east = (Door)room.getEastBarrier();
                Door west = (Door)room.getWestBarrier();

                try
                {
                    north.setQuestion(factory.getQuestion());
                    south.setQuestion(factory.getQuestion());
                    east.setQuestion(factory.getQuestion());
                    west.setQuestion(factory.getQuestion());
                }

                catch(Exception e)
                {
                    System.out.println("Something went Wrong");
                }


                if(x == 0) //first row of maze
                    room.setNorthBarrier(new Wall());

                if(x == row-1)
                    room.setSouthBarrier(new Wall());

                if(y == 0) //first column of maze
                    room.setWestBarrier(new Wall());

                if(y == col-1) //last column of maze
                    room.setEastBarrier(new Wall());

                rooms[x][y] = room;
            }
        }

        currentRoom = rooms[playerRow][playerCol];

        rooms[row-1][col-1].makeExit();
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
            Door door = (Door)barrier;

            if(door.isOpen())
            {
                movePlayerOneSpace(direction);
                return true;
            }

            if(answersDoorQuestionCorrectly(door))
            {
                movePlayerOneSpace(direction);
                return true;
            }

            else
            {
                System.out.println("Locking " + direction + " Door");
                lockDoor(door, direction);
                canSolve();
            }
        }

        System.out.println();
        return  false;
    }

    private boolean answersDoorQuestionCorrectly(Door door)
    {
        Question q = door.getQuestion();
        System.out.println();
        Scanner kb = new Scanner(System.in);

        System.out.println(q);
        System.out.print("Answer --> ");
        String userAnswer = kb.nextLine();
        userAnswer = userAnswer.trim().toLowerCase();

        boolean rightAnswer = q.checkAnswer(userAnswer);

        if(rightAnswer)
        {
            System.out.println("Correct!");
            return true;
        }

        else
        {
            System.out.println("Sorry, the correct answer was - " + q.getAnswer());
            return false;
        }
    }

    private void lockDoor(Door door, String direction)
    {
        Door otherSide = new Door();

        switch(direction)
        {
            case "north":
                door = (Door)currentRoom.getNorthBarrier();
                otherSide = (Door)rooms[playerRow - 1][playerCol].getSouthBarrier();
                break;
            case "south":
                door = (Door)currentRoom.getSouthBarrier();
                otherSide = (Door)rooms[playerRow + 1][playerCol].getNorthBarrier();
                break;
            case "east":
                door = (Door)currentRoom.getEastBarrier();
                otherSide = (Door)rooms[playerRow][playerCol + 1].getWestBarrier();
                break;
            case "west":
                door = (Door)currentRoom.getWestBarrier();
                otherSide = (Door)rooms[playerRow][playerCol - 1].getEastBarrier();
                break;
        }

        otherSide.lock();
        door.lock();
    }

    public void movePlayerOneSpace(String direction) {

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

    public boolean canSolve()
    {
        return canSolveHelper(playerRow, playerCol, "start");
    }

    private boolean canSolveHelper(int row, int col, String whereWeCameFrom){

        Room cur = rooms[row][col];

        boolean foundTheExit = false;

        if(cur.isTheExit())
            foundTheExit = true;

        //east
        if(!foundTheExit && !whereWeCameFrom.equals("east") && canMovecanSolve(cur.getEastBarrier()))
            foundTheExit = canSolveHelper(row, col+1, "west");

        if(!foundTheExit && !whereWeCameFrom.equals("west") && canMovecanSolve(cur.getWestBarrier()))
            foundTheExit = canSolveHelper(row, col-1, "east");

        if(!foundTheExit && !whereWeCameFrom.equals("south") && canMovecanSolve(cur.getSouthBarrier()))
            foundTheExit = canSolveHelper(row+1, col, "north");

        if(!foundTheExit && !whereWeCameFrom.equals("north") && canMovecanSolve(cur.getNorthBarrier()))
            foundTheExit = canSolveHelper(row-1, col, "south");

        return foundTheExit;
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
        String s = "P: Player\nE: Exit\n";
        return(s +  "***********\n" +
                "*P| | | | *\n" +
                "*-*-*-*-*-*\n" +
                "* | | | | *\n" +
                "*-*-*-*-*-*\n" +
                "* | | | | *\n" +
                "*-*-*-*-*-*\n" +
                "* | | | |E|\n" +
                "***********\n");
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    private boolean canMovecanSolve(IBarrier barrier)
    {
        if(barrier.isAWall())
            return false;

        Door d = (Door)barrier;

        if(d.isLocked())
            return false;

        return true;
    }

    public void setPlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public Player getPlayer() {
        return thePlayer;
    }
}
