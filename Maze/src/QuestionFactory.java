import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class QuestionFactory {
    private Question theQuestion;
    public QuestionFactory(){

    }
    public Question getTheQuestion(){
        // this will return a random question
        Random rand = new Random(System.currentTimeMillis());
        int toChose;
        Connection myCon = connectToDataBase();
        String [] databases = {"MultipleChoice" , "ShortAnswer" , "TrueFalse"};
        int [] questionCounts = {countQuestions(myCon , databases[0]) , countQuestions(myCon , databases[1]) , countQuestions(myCon , databases[2])};
        int numberOfQuestions = questionCounts[0] +  questionCounts[1] + questionCounts[2]; // will be the number of the questions in the database
        toChose = rand.nextInt(numberOfQuestions +1 );
        String databaseToGetQuestionFrom = choseTable(databases , questionCounts , numberOfQuestions);
        ResultSet results = queryTheDatabase(myCon , toChose , databaseToGetQuestionFrom);
        // have the question here need to know the constructors for the types of questions and then will add based on the String
        // databaseToGetQuestionsFrom
        return null;
    }
    private String choseTable(String [] databases , int[] counts , int total ){
        int choice = 0;
        for(int i = 0 ; i < counts.length ; i++){
            if(total - counts[i] > 0 ){
                total = total - counts[i];
                choice++;
            }
        }
        return databases[choice];
    }

    private int countQuestions(Connection theDatabase , String whichDatabase){
        String SQL  = "SELECT * FROM " + whichDatabase;
        int count = 0;
        try{
            Statement test = theDatabase.createStatement();
            ResultSet results = test.executeQuery(SQL);
            while(results.next()) {
                count++;
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private ResultSet queryTheDatabase(Connection theDatabase , int toGet , String table){
        String sql  = "SELECT * FROM "+theDatabase +" WHERE id=" + toGet;
        try{
            Statement test = theDatabase.createStatement();
            return test.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Connection connectToDataBase(){
        String initPath;
        File databasePath = null;
        try{
            initPath =  ".." +File.separator +  "database" + File.separator+"test.db" ;

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

}

