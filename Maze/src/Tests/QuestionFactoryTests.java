package Tests;

import org.junit.jupiter.api.Test;
import questions.Question;
import questions.QuestionFactory;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionFactoryTests {
    @Test
    public void constructor_noInputRequired_returnsObject(){
        assertNotNull(new QuestionFactory());
        assertTrue(new QuestionFactory() instanceof QuestionFactory);
    }
    @Test
    public void getQuestion_noInputRequired_returnsValidObject() throws SQLException {
        QuestionFactory t = new QuestionFactory();
        assertNotNull(t.getQuestion());
    }
    @Test
    public void getQuestion_noInputRequired_returnsValidQuestion() throws SQLException {
        QuestionFactory t = new QuestionFactory();
        assertTrue(t.getQuestion() instanceof Question);
    }


}
