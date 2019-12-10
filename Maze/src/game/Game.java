package game;

import maze.Maze;
import game.Player;

import java.io.*;
import java.util.Scanner;

public class Game {
    // will handle the game menus
    // moving and stuff like that
    private Maze theMaze;
    private boolean gameIsSaved;
    private boolean gameIsOver;
    private final String [] saves;
    public Game() throws IOException {
        // names of the save files more can be added for release
        this.saves = new String[] {"save1", "save2", "save2"};
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter your name");


        String playerName = kb.nextLine();
        Player thePlayer = new Player();
        thePlayer.setName(playerName);

        theMaze = new Maze(5, 5);
        theMaze.setPlayer(thePlayer);

        gameIsSaved = false;
        gameIsOver =false;
        System.out.println();
        System.out.println("ALERT - This is a Harry Potter Themed Maze and will ask you HP universe questions");
        System.out.println("If you don't know harry potter and don't want spoilers, turn back now");
        System.out.println();
        System.out.println("Starting New Game, this is the maze Layout");
        System.out.println(theMaze.getMazeLayout());
    }
    public Game(Maze savedGame){
        this.saves = new String[] {"save1", "save2", "save3"};
        gameIsSaved = true;
        gameIsOver = false;
        // this may be incorrect
        // is it possible for the game to be over and then be saved if no then no changes nessessary
        this.theMaze = savedGame;
        System.out.println("Starting saved game, here is where you left off:");
        System.out.println(theMaze.getMazeLayout());
    }

    public boolean isGameOver(){
        return gameIsOver;
    }


    public int movePlayer() throws IOException {

        Scanner input = new Scanner(System.in);
        String choice;

        do {

            if(theMaze.getCurrentRoom().isTheExit()) {
                System.out.println("You Found the Exit! Congratulations!");
                System.out.println();
                System.out.println("CREDITS:");
                System.out.println("Triple Threat");
                System.out.println("    Fearless Leader - Daylyn Hoxie");
                System.out.println("    Code Monkey - Spencer Curley");
                System.out.println("    Moral Support - Raymond Shiner");
                System.out.println();
                System.out.println("Thanks for Playing!");

                gameIsOver = true;
                return 0;
            }


            theMaze.printCurrentRoom();

            System.out.println(theMaze.getPlayer().getName() + " - Please make a move (north, south, east, west, quit, save):");
            System.out.print("Choice --> ");
            choice = input.nextLine();

            boolean choiceIsQuit = choice.equalsIgnoreCase("quit");
            boolean choiceIsSave = choice.equalsIgnoreCase("save");



            if(choiceIsSave) {
                System.out.println("Saving Game");
                FileOutputStream file = new FileOutputStream("test.bin");
                ObjectOutputStream tmp = new ObjectOutputStream(file);
                tmp.writeObject(theMaze);
                tmp.close();
                file.close();
                gameIsSaved = true;
            }

            else if(choiceIsQuit) {
                if(userWantsToQuit(input)){
                    this.gameIsOver = true;
                    return -1;
                }
            }

            else if(!choiceIsValidMove(choice)) {
                System.out.println("ERROR - Please enter valid choice");
            }

        }while(!choiceIsValidMove(choice));

        theMaze.move(choice);
        if(!theMaze.canSolve()){
            System.out.println("\"There is no way out... They are Coming\"");
            System.out.println("You have locked yourself in the maze");
            System.out.println("GAME OVER");
            gameIsOver = true;
        }

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
        System.out.println("Here are your saves to choose from ");
        for(int i = 0 ; i < saves.length ; i++){
            System.out.println(i +": " + saves[i]);
        }
        System.out.println("Please choose the number that you would like to save your game to");
    }

    private boolean userWantsToQuit(Scanner input){
        boolean tryAgain;
        if(!gameIsSaved){
            String q = "Does the user really want to quit without saving? y/n - ";
            System.out.println(q);
            String choice = input.nextLine();
            do{

                if(choice.equalsIgnoreCase("y")){
                    return true;
                }else if(choice.equalsIgnoreCase("n")){
                    return false;
                }
                System.out.println("Invalid input, please try again");
                System.out.println(q);
                choice = input.nextLine();
                tryAgain = true;
            }while(tryAgain);

        }else{
            return true;
        }
        return false;
    }







}
