import java.util.Scanner;

public class Game {
    // will handle the game menue
    // moving and stuff like that
    private Maze theMaze;
    private boolean gameIsSaved;
    private boolean gameIsOver;
    public Game(){
        theMaze = new Maze();
        gameIsSaved = false;
        gameIsOver =false;
    }
    public boolean isGameOver(){
        return gameIsOver;
    }
    public int printMenu(){
        // print maze
        System.out.println(theMaze);
        Scanner input = new Scanner(System.in);
        System.out.println("this is the fancy game menu 5 = quit ");
        int choice = input.nextInt();
        input.nextLine();
        switch(choice){
            case 0:
                // this would be move up
                break;
            case 1 :
                // this would be move down
                break;
            case 2:
                // this would be move left
                break;
            case 3:
                // this would be move right
                break;
            case 4:
                // this would be save
                break;
            case 5:
                //this would be quit
                if(quit(input)){
                    this.gameIsOver = true;
                    return 0;
                }
                break;

        }
        return 0;
    }
    public int processMenu(){
        return 0;
    }
    private boolean quit(Scanner input ){
        boolean tryAgain = false;
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
