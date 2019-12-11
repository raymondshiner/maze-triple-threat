package questions;

import questions.implementations.MultipleChoice;
import questions.Question;
import questions.implementations.ShortAnswer;
import questions.implementations.TrueFalse;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class QuestionFactory{
    private Connection connection;
    private Random r;

    public QuestionFactory(){
        connection = connectToDataBase();
        r = new Random(System.currentTimeMillis());
    }

    public Question getQuestion() throws SQLException {

        int choice = getRandom(3);
        Question q;
        int random;
        ResultSet results;

        switch(choice){
            case 0:
                int tmp3 = countQuestions("MultipleChoice");
                random = getRandom(tmp3);
                results = queryTheDatabase(random+1 , "MultipleChoice");
                String tmp [] = {results.getString("a") , results.getString("b"), results.getString("c") ,results.getString("d")};
                String correct = results.getString("Answer") ;
                q = new MultipleChoice( results.getString("Question"), tmp, correct );
                break;
            case 1:
                int tmp2 = countQuestions("ShortAnswer");
                random = getRandom(tmp2);
                results = queryTheDatabase(random +1  , "ShortAnswer");
                q = new ShortAnswer(results.getString("Question") , results.getString("Answer") );
                break;
            default:
                int tmp1 = countQuestions("TrueFalse");
                random = getRandom(tmp1);
                results = queryTheDatabase(random+1 , "TrueFalse");
                q = new TrueFalse(results.getString("Question") , results.getString("Answer"));
                break;
        }
        return q;
    }

    private int getRandom(int bound){
        return r.nextInt(bound);
    }

    private int countQuestions(String table){
        String SQL  = "SELECT * FROM " + table;
        int count = 0;
        try{
            Statement test = connection.createStatement();
            ResultSet results = test.executeQuery(SQL);
            while(results.next()){
                count++;
            }
            results.close();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Connection connectToDataBase(){
        String initPath;
        File databasePath = null;
        try{
            initPath =  ".." +File.separator +  "database" + File.separator+"realdb.db" ;

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
    private ResultSet queryTheDatabase( int toGet, String table){
        String sql  = "SELECT * FROM "+table +" WHERE id=" + toGet;
        try{
            Statement test = connection.createStatement();
            ResultSet tmp = test.executeQuery(sql);
            return tmp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void closeDatabase(){
        try{
            connection.close();
        }catch(SQLException e ){

        }

    }


}
