import java.util.Scanner;

public class Game {
    // will handle the game menue
    // moving and stuff like that
    private Maze theMaze;
    private boolean gameIsSaved;
    private boolean gameIsOver;
    public Game(){
        theMaze = new Maze(new Player());
        gameIsSaved = false;
        gameIsOver =false;
        System.out.println("Starting New Game, this is the maze Layout");
        System.out.println(theMaze.getMazeLayout());
    }
    public boolean isGameOver(){
        return gameIsOver;
    }


    public int moveMenu(){

        Scanner input = new Scanner(System.in);
        String choice;

        do {
            theMaze.printCurrentRoom();

            System.out.println("Please make a move (north, south, east, west, quit, save):");
            System.out.print("Choice --> ");
            choice = input.nextLine();

            boolean choiceIsQuit = choice.equalsIgnoreCase("quit");
            boolean choiceIsSave = choice.equalsIgnoreCase("save");



            if(choiceIsSave)
            {
                System.out.println("Saving Game");
            }

            else if(choiceIsQuit)
            {
                if(userWantsToQuit(input)){
                    this.gameIsOver = true;
                    return -1;
                }
            }

            else if(!choiceIsValidMove(choice))
            {
                System.out.println("ERROR - Please enter valid choice");
            }

        }while(!choiceIsValidMove(choice));

        theMaze.move(choice);
        return 0;
    }

    private boolean choiceIsValidMove(String choice) {
        choice = choice.toLowerCase().trim();

        if(choice.equals("north")
                || choice.equals("south")
                || choice.equals("east")
                || choice.equals("west"))
            return true;

        return false;

    }


    private boolean userWantsToQuit(Scanner input){
        boolean tryAgain;
        if(!gameIsSaved){
            System.out.println("does the user really want to quit without saving y/n");
            String choice = input.nextLine();
            do{

                if(choice.equalsIgnoreCase("y")){
                    return true;
                }else if(choice.equalsIgnoreCase("n")){
                    return false;
                }
                System.out.println("invalid input try again");
                System.out.println("does the user really want to quit without saving y/n");
                choice = input.nextLine();
                tryAgain = true;
            }while(tryAgain);

        }else{
            return true;
        }
        return false;
    }







}
