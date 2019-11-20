public class Maze {
    private Room [][] rooms;
    private Player player;
    private int playerRow;
    private int playerCol;

    public Maze(){

        System.out.println();
    }

    private void buildMaze(){
        // called by constructor

    }
    public void moveUp(){

    }
    public void moveDown(){

    }
    public void moveLeft(){

    }
    public void moveRight(){

    }
    private boolean canSolve(){
        // called after every failed trivia question
        return false;
    }

    public String displayMaze(){
        String s = "P: Player\nE: Exit";
        return(s + "\n************\n" +
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
                "************\n");
    }



}
