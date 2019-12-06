import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class QuestionFactory {
    private Question theQuestion;
    public QuestionFactory(){

    }
    public Question getTheQuestion() throws SQLException {
        // this will return a random question
        Random rand = new Random(System.currentTimeMillis());
        int toChose;
        Connection myCon = connectToDataBase();
        String [] databases = {"MultipleChoice" , "ShortAnswer" , "TrueFalse"};
        int [] questionCounts = {countQuestions(myCon , databases[0]) , countQuestions(myCon , databases[1]) , countQuestions(myCon , databases[2])};
        int numberOfQuestions = questionCounts[0] +  questionCounts[1] + questionCounts[2]; // will be the number of the questions in the database
        toChose = rand.nextInt(numberOfQuestions +1 );
        String databaseToGetQuestionFrom = choseTable(databases , questionCounts , numberOfQuestions);
        toChose = choseNum(questionCounts , toChose);
        ResultSet results = queryTheDatabase(myCon , toChose , databaseToGetQuestionFrom);
        //results.next();
        // have the question here need to know the constructors for the types of questions and then will add based on the String
        // databaseToGetQuestionsFrom
        switch(databaseToGetQuestionFrom){
            case "MultipleChoice":
                String tmp [] = {results.getString("a") , results.getString("b"), results.getString("c") ,results.getString("d")};
                String correct = results.getString("Answer") ;
                return new MultipleChoice( results.getString("Question"), tmp, correct );

            case "ShortAnswer":
                return new ShortAnswer(results.getString("Question") , results.getString("Answer") );

            case "TrueFalse":
                return new TrueFalse(results.getString("field1") , results.getString("field2"));
            default:
                break;
        }
        return null;
    }
    private int choseNum(int[] counts , int total){
       // int choice = 0;
        for(int i = 0 ; i < counts.length ; i++){
            if(total - counts[i] > 0 ){
                total = total - counts[i];
               // choice++;
            }
        }
        return total;
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
            results.close();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private ResultSet queryTheDatabase(Connection theDatabase , int toGet , String table){
        String sql  = "SELECT * FROM "+table +" WHERE id=" + toGet;
        try{
            Statement test = theDatabase.createStatement();
            ResultSet tmp = test.executeQuery(sql);
            return tmp;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Connection connectToDataBase(){
        String initPath;
        File databasePath = null;
        try{
            initPath =  ".." +File.separator +  "database" + File.separator+"thisisatest.db" ;

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

