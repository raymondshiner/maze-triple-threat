import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    // this will handle everything before the game starts
    // load
    // new
    //exit
    private static Game theGame;
    private static DatabaseAdminTool adminTool;
    public static void main(String [] args) throws IOException, ClassNotFoundException, SQLException {
        //playGameMenu();
        adminTool = new DatabaseAdminTool();
       /* QuestionFactory tmp = new QuestionFactory();
        for(int i  = 0 ; i < 100 ; i++){
            Question t = tmp.getQuestion();
            System.out.println(t);
        }

        */
       DatabaseAdminTool tmp = new DatabaseAdminTool();
       Scanner input = new Scanner(System.in);
       tmp.addQuestion(input);


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
    public static void playGameMenu() throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Trivia Maze");

        String choice;
        boolean done = false;
        do{
            // this will be the before game loop
            // asks user if want to start a new game else quit
            // possible load saved games from this menu
            
            System.out.println("1 Would you like to start a new game ? ");
            System.out.println("2 Would you like load a previous game ?");
            System.out.println("3 Add a question");
            System.out.println("4 quit ");

            choice = input.nextLine();
            if(choice.equals("1")){
                // this is the only call to the game object right now
                theGame = new Game();
                do{
                    playGameTurn();
                }while(!theGame.isGameOver());
                // create and start game
                done = false;
            }else if(choice.equalsIgnoreCase("3")){
                // exit while loop so that the program will stop
                adminTool.addQuestion(input);
                done = false;
            }else if(choice.equalsIgnoreCase("4")){
                done = true;
            }else if (choice.equalsIgnoreCase("2")){
                // load game
                try{
                    FileInputStream ifile = new FileInputStream("test.bin");
                    ObjectInputStream igame = new ObjectInputStream(ifile);
                    theGame  =  new Game( (Maze) igame.readObject());
                }catch(IOException e ) {
                    System.out.println(e);
                    return;
                }catch (ClassNotFoundException e ) {
                    return;
                }
                do{
                    playGameTurn();
                }while(!theGame.isGameOver());
            }else{
                // not a valid choice try again
                System.out.println("Not a valid choice try again");
            }
        }while(!done);
    }
    private static int playGameTurn() throws IOException {
        theGame.moveMenu();

        return 0;
    }
}
