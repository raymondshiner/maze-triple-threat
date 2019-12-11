package Tests;

import Tests.mockObjects.TestableQuestion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTests {


    @Test
    public void constructor_NullQuestion_ThrowsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            TestableQuestion t = new TestableQuestion(null, "Good");
        });
    }


    @Test
    public void constructor_EmptyQuestion_ThrowsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            TestableQuestion t = new TestableQuestion("", "Good");
        });
    }


    @Test
    public void constructor_NullAnswer_ThrowsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            TestableQuestion t = new TestableQuestion("Good", null);
        });
    }

    @Test
    public void constructor_EmptyAnswer_ThrowsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            TestableQuestion t = new TestableQuestion(null, "");
        });
    }


    @Test
    public void constructor_validInput_objectCreated(){
        String question = "testQuestion";
        String answer = "testAnswer";
        assertNotNull( new TestableQuestion(question,answer) );
    }
    @Test
    public void checkAnswer_inputCheatCode_ReturnsTrue(){

            String question = "testQuestion";
            String answer = "testAnswer";
            assertTrue(  new TestableQuestion(question,answer).checkAnswer("42") );
    }
    @Test
    public void checkAnswer_inputWrongAnswer_ReturnsFalse(){

        String question = "testQuestion";
        String answer = "testAnswer";
        assertFalse(  new TestableQuestion(question,answer).checkAnswer("tasdfga") );
    }
    @Test
    public void checkAnswer_inputCorrectAnswer_ReturnsTrue(){

        String question = "testQuestion";
        String answer = "testAnswer";
        assertTrue(  new TestableQuestion(question,answer).checkAnswer("testAnswer") );
    }
    @Test
    public void toString_constructor_ReturnsCorrectString(){

        String question = "testQuestion";
        String answer = "testAnswer";
        assertEquals( "testQuestion" ,  new TestableQuestion(question,answer).toString() );
    }
    @Test
    public void getAnswer_constructor_ReturnsCorrectString(){

        String question = "testQuestion";
        String answer = "testAnswer";
        assertEquals( "testAnswer" ,  new TestableQuestion(question,answer).getAnswer() );
    }

    @Test
    public void checkAnswer_NullInput_ReturnsFalse(){

        TestableQuestion t = new TestableQuestion("good", "good");
        assertEquals(false, t.checkAnswer(null));
    }
}
