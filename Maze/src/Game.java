import java.util.Scanner;

public class Game {
    // will handle the game menue
    // moving and stuff like that
    private Maze theMaze;
    private boolean saved;
    private boolean over;
    public Game(){
        theMaze = new Maze();
        saved = false;
        over =false;
    }
    public boolean isOver(){
        return over;
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
                    this.over = true;
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
        if(!saved){
            System.out.println("does the user really want to quit without saving y/n");
            String choice = input.nextLine();
            do{

                if(choice.equals("y")){
                    return true;
                }else if(choice.equals("n")){
                    return false;
                }
                System.out.println("invalid input try again");
                System.out.println("does the user really want to quit without saving y/n");
                choice = input.nextLine();

            }while(1 == 1);

        }else{
            return true;
        }

    }







}
