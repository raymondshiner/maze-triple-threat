import java.io.*;
import java.util.Scanner;

public class Game {
    // will handle the game menue
    // moving and stuff like that
    private Maze theMaze;
    private boolean gameIsSaved;
    private boolean gameIsOver;
    private final String [] saves;
    public Game() throws IOException {
        // names of the save files more can be added for release
        this.saves = new String[] {"save1", "save2", "save2"};
        theMaze = new Maze(new Player());
        gameIsSaved = false;
        gameIsOver =false;
        System.out.println("Starting New Game, this is the maze Layout");
        System.out.println(theMaze.getMazeLayout());
    }
    public Game(Maze savedGame){
        this.saves = new String[] {"save1", "save2", "save2"};
        gameIsSaved = true;
        gameIsOver = false;
        // this may be incorrect
        // is it possible for the game to be over and then be saved if no then no changes nessessary
        this.theMaze = savedGame;
        System.out.println("Starting saved game here is where you left off ");
        System.out.println(theMaze.getMazeLayout());
    }

    public boolean isGameOver(){
        return gameIsOver;
    }


    public int moveMenu() throws IOException {

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
                FileOutputStream file = new FileOutputStream("test.bin");
                ObjectOutputStream tmp = new ObjectOutputStream(file);
                tmp.writeObject(theMaze);
                tmp.close();
                file.close();
                gameIsSaved = true; 
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
    private void userWantsToSave(Scanner input){
        do{
            printSaves();
            int userChoice = input.nextInt();
        }while(true);


    }
    private void printSaves(){
        System.out.println("here are your saves to choose from ");
        for(int i = 0 ; i < saves.length ; i++){
            System.out.println(i +": " +saves[i]);
        }
        System.out.println("please choose the number that you would like to save your game to");
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
