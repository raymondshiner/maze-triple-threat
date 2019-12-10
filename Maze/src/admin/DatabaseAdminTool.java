package admin;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DatabaseAdminTool {
    private Connection theConnection;
    public DatabaseAdminTool(){
        theConnection = connectToDataBase();
    }
    public boolean addQuestion(Scanner input ){

        try{
            // returns true if a question was added false if not
            System.out.println("what type of question would you like to add to the database");
            System.out.println("1. True false");
            System.out.println("2. Short answer ");
            System.out.println("3. Multiple choice ");
            int choice = input.nextInt();
            input.nextLine();
            String sqlStatement = "";
            String theQuestion;
            String answer;
            switch(choice){
                case 1:
                    // add a true or false
                    System.out.println("please enter the question");
                    theQuestion = input.nextLine();
                    System.out.println("Please enter the answer TRUE or FALSE");
                    answer = input.nextLine();
                    //INSERT INTO "TrueFalse" VALUES ('Albus Dumbledore''s full name is Albus Percival Wulfric Brian Dumbledore','TRUE');
                    sqlStatement = "INSERT INTO \"TrueFalse\" VALUES (\"" +preventSQLInjection( theQuestion) + "\",\"" + preventSQLInjection(answer) + "\",?)";
                    System.out.println(sqlStatement);
                    if (addQuestionToDatabase(sqlStatement)){
                        return false;
                    }
                    break;
                case 2:
                    //INSERT INTO "ShortAnswer" VALUES ('Who creates the slug club?','Slughorn');

                    System.out.println("please enter the question");
                    theQuestion = input.nextLine();
                    System.out.println("Please enter the answer");
                    answer = input.nextLine();
                    // add a short answer
                    sqlStatement = "INSERT INTO \"ShortAnswer\" VALUES (\"" + preventSQLInjection(theQuestion) + "\",\"" + preventSQLInjection(answer) + "\",?)";
                    System.out.println(sqlStatement);
                    if (addQuestionToDatabase(sqlStatement)){
                        return false;
                    }
                    break;
                case 3:
                    //INSERT INTO "MultipleChoice" VALUES ('Who kills Cedric Diggory on Lord Voldemort''s orders?','c','Draco Malfoy','Severus Snape','Peter Pettigrew','Sirius Black');
                    String [] answers = new String [4];
                    System.out.println("please enter the question");
                    theQuestion = input.nextLine();
                    System.out.println("please enter the answers newline separated. Make sure that there are exactly 4 possible answers. \n The order does not matter");
                    answers[0] = input.nextLine();
                    answers[1] = input.nextLine();
                    answers[2] = input.nextLine();
                    answers[3] = input.nextLine();
                    System.out.println("please say which is the correct one by number entered ");
                    String correctAnswer = input.next();
                    // add a multiple choice
                    sqlStatement = "INSERT INTO \"MultipleChoice\" VALUES (\"" + preventSQLInjection(theQuestion )+ "\",\"" + preventSQLInjection(correctAnswer) + "\",\"" + preventSQLInjection(answers[0]) + "\",\"" + preventSQLInjection(answers[1]) +"\",\"" + preventSQLInjection(answers[2]) +"\",\"" + preventSQLInjection(answers[3])+ "\",?)";
                    if (addQuestionToDatabase(sqlStatement)){
                        return false;
                    }
                    break;
                default:
                    System.out.println("invalid choice prompting again");
                    return addQuestion(input);
            }
            return false;
        }catch (InputMismatchException e){
            System.out.println(e + "\n Try again" );
            input.nextLine();
            return  addQuestion(input);
        }

    }
    // creates the sql statement to add the question to the database
    // then calls addQuestionToDatabase that will execute the query
    private void addMultipleChoice(){

    }
    private void addShortAnswer(){

    }
    private void addTrueFalse(){

    }
    private boolean addQuestionToDatabase(String sql ){
        try{
            Statement test = theConnection.createStatement();
            test.executeUpdate(sql);
            return true;

        } catch (Exception e) {
            System.out.println("I solemnly swear i'm upto no good won't help you here. \n Even cheats wont let you sql inject this code ");
            return false;
        }
    }

    private Connection connectToDataBase(){
        String initPath;
        File databasePath = null;
        try{
            initPath =  ".." +File.separator +  "database" + File.separator+"realdb.db";

            databasePath = new File(initPath);
            // System.out.println(initPath + "\n" + databasePath.getCanonicalPath());
        }catch(Exception e ){
            System.out.println(e);
        }
        Connection myCon;
        String USR = "root";
        String password ="thisisastupidpassword";
        try{
            Class.forName("org.sqlite.JDBC");
            myCon = DriverManager.getConnection("jdbc:sqlite:" +databasePath.getCanonicalPath(),USR ,password);
            return myCon;
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void closeDatabse()  {
        try{
            theConnection.close();
        }catch(SQLException e ){

        }

    }
    public String preventSQLInjection(String str) {
        String data = null;
        if (str != null && str.length() > 0) {
            str = str.replace("\\", "\\\\");
            str = str.replace("'", "\\'");
            str = str.replace("\"", "\\\"");
            str = str.replace("\\x1a", "\\Z");
            data = str;
        }
        return data;
    }

}

