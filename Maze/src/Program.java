import admin.DatabaseAdminTool;
import game.Game;
import maze.Maze;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    // this will handle everything before the game starts
   
    private static Game theGame;
    private static DatabaseAdminTool adminTool;
    public static void main(String [] args) throws IOException, ClassNotFoundException, SQLException {
        adminTool = new DatabaseAdminTool();
        playGameMenu();
       
    }

    public static void playGameMenu() throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Trivia Maze");

        String choice;
        boolean donePlaying = false;
        do{
            
            System.out.println("1 Would you like to start a new game ? ");
            System.out.println("2 Would you like load a previous game ?");
            System.out.println("3 Add a question");
            System.out.println("4 quit ");

            choice = input.nextLine();

            switch(choice)
            {
                case "1": //new Game

                    theGame = new Game();
                    playTheGame();
                    break;

                case "2": //load Game

                    try{
                        FileInputStream ifile = new FileInputStream("test.bin");
                        ObjectInputStream igame = new ObjectInputStream(ifile);
                        theGame  =  new Game( (Maze) igame.readObject());
                    }

                    catch(IOException e ) {
                        System.out.println(e);
                        return;
                    }

                    catch (ClassNotFoundException e ) {
                        System.out.println(e);
                        return;
                    }

                    playTheGame();
                    break;

                case "3": //add Question

                    adminTool.addQuestion(input);
                    break;

                case "4": //quit

                    donePlaying = true;
                    break;

                default:
                    System.out.println("Not a valid choice try again");
                    break;
            }

        }while(!donePlaying);
    }

    private static void playTheGame() throws IOException {

        do {
            theGame.movePlayer();
        }while(!theGame.isGameOver());
    }
}
