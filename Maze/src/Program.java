import java.util.Scanner;

public class Program {
    // this will handle everything before the game starts
    // load
    // new
    //exit
    private static Game theGame;
    public static void main(String [] args)
    {
        QuestionFactory tmp = new QuestionFactory();
        Question theQuestion = tmp.getTheQuestion();
        playGameMenu();


        /*
        //MultipleChoice tmp = new MultipleChoice();

        Door up = new Door();
        up.lock();

        Door down = new Door();
        down.open();

        Wall left = new Wall();
        Door right = new Door();

        Room room = new Room();

        room.setNorthBarrier(up);
        room.setEastBarrier(right);
        room.setWestBarrier(left);
        room.setSouthBarrier(down);

        room.displayRoom();
        //System.out.println("Hello World!");
        //did this work
        playGameMenu();
        */
    }
    public static void playGameMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Trivia Maze");

        String choice;
        boolean done = false;
        do{
            // this will be the before game loop
            // asks user if want to start a new game else quit
            // possible load saved games from this menu
            
            System.out.println("Would you like to start a new game ? y/n");
            choice = input.nextLine();
            if(choice.equals("y")){
                // this is the only call to the game object right now
                theGame = new Game();
                do{
                    playGameTurn();
                }while(!theGame.isGameOver());
                // create and start game
                done = false;
            }else if(choice.equalsIgnoreCase("n")){
                // exit while loop so that the program will stop
                done = true;
            }else{
                // not a valid choice try again
                System.out.println("Not a valid choice try again");
            }
        }while(!done);
    }
    private static int playGameTurn(){
        theGame.moveMenu();

        return 0;
    }
}
