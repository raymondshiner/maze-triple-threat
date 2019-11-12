import java.io.File;
import java.io.IOException;
import java.sql.*;

public class MultipleChoice extends Question{
    private String [] thePossibleAnswers;
    private String theCorrectAnswer;
    public MultipleChoice() {

        super("the test of the question class" );
        String initPath;
        File databasePath = null;
        try{
            initPath =  ".." +File.separator +  "database" + File.separator+"test.db" ;

            databasePath = new File(initPath);
           // System.out.println(initPath + "\n" + databasePath.getCanonicalPath());
        }catch(Exception e ){
            System.out.println(e);
        }

        // this is a problem because it uses the absolute path and my path is different than others so need to figure out how to use relitive paths and make it cross platform or just move the database file into the defualt directory that jdbc will look for the database .db file
        String URL = "jdbc:sqlite:/Users/spencercurley/Desktop/cscd350/maze-triple-threat/database/test.db";
        String USR = "root";
        String password ="thisisastupidpassword";
        Connection myCon = null;
        try{
            Class.forName("org.sqlite.JDBC");
            myCon = DriverManager.getConnection("jdbc:sqlite:" +databasePath.getCanonicalPath(),USR ,password);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM Question";
        try{
            Statement test = myCon.createStatement();
            ResultSet results = test.executeQuery(sql);
            while(results.next()){
                // this demonstrates how to get stuff back from the database
                // to add data to a question we will need to figure out how to get the number of records in the database for the random number generator

                System.out.println(results.getString("Question") + " and the answer is " + results.getString("Answer") );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // this will be replaced with the database information soon g
        this.thePossibleAnswers = new String[4];
        this.thePossibleAnswers[0] = "1";
        this.thePossibleAnswers[1] = "2";
        this.thePossibleAnswers[2] = "3";
        this.thePossibleAnswers[3] = "42";
        this.theCorrectAnswer = "42";
    }
    @Override
    public boolean checkAnswer(String toCheck) {
        return toCheck.equals(this.theCorrectAnswer);
    }
}
