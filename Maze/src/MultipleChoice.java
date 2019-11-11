import java.sql.*;

public class MultipleChoice extends Question{
    private String [] thePossibleAnswers;
    private String theCorrectAnswer;
    public MultipleChoice() {

        super("the test of the question class" );
        // this is a problem because it uses the absolute path and my path is different than others so need to fiqure out how to use relitive paths and make it cross platform or just move the database file into the defualt directory that jdbc will look for the database .db file 
        String URL = "jdbc:sqlite:/Users/spencercurley/Desktop/cscd350/maze-triple-threat/database/test.db";
        String USR = "root";
        String password ="thisisastupidpassword";
        Connection myCon = null;
        try{
            Class.forName("org.sqlite.JDBC");
            myCon = DriverManager.getConnection(URL,USR ,password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM Question";
        try{
            Statement test = myCon.createStatement();
            ResultSet results = test.executeQuery(sql);
            while(results.next()){
                System.out.println(results.getString("Question") + " and the answer is " + results.getString("Answer") );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

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
