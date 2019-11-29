import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DatabaseHandler {

    File databasePath;
    Connection connection;

    public DatabaseHandler() {
        setDatabasePath();
        setConnection();
    }

    private void setConnection() {
        // this is a problem because it uses the absolute path and my path is different than others so need to figure out how to use relitive paths and make it cross platform or just move the database file into the defualt directory that jdbc will look for the database .db file
        String URL = "jdbc:sqlite:/Users/spencercurley/Desktop/cscd350/maze-triple-threat/database/test.db";
        String USR = "root";
        String password = "thisisastupidpassword";
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath.getCanonicalPath(), USR, password);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private void setDatabasePath() {
        try {
            String initPath = ".." + File.separator + "database" + File.separator + "test.db";
            databasePath = new File(initPath);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void getStatements() {
        String sql = "SELECT * FROM Question";
        try {
            Statement test = connection.createStatement();
            ResultSet results = test.executeQuery(sql);
            while (results.next()) {
                // this demonstrates how to get stuff back from the database
                // to add data to a question we will need to figure out how to get the number of records in the database for the random number generator
                System.out.println(results.getString("Question") + " and the answer is " + results.getString("Answer"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
