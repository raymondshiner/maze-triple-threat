import java.util.Scanner;

public class Program {
    // this will handle everything before the game starts
    // load
    // new
    //exit
    private static Game theGame;
    public static void main(String [] args)
    {
        //MultipleChoice tmp = new MultipleChoice();

        //System.out.println("Hello World!");
        //did this work
        firstMenu();
    }
    public static void firstMenu(){
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
                }while(!theGame.isOver());
                // create and start game
                done = false;
            }else if(choice.equals("n")){
                // exit while loop so that the program will stop
                done = true;
            }else{
                // not a valid choice try again
                System.out.println("Not a valid choice try again");
                done = false;
            }
        }while(!done);
    }
    private static int playGameTurn(){
        theGame.printMenu();

        return 0;
    }
}
