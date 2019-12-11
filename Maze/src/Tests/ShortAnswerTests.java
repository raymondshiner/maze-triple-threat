package Tests;

import org.junit.jupiter.api.Test;
import questions.implementations.ShortAnswer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShortAnswerTests {
    @Test
    public void toString_validArguments_ReturnsString(){
        String question = "testQuestion";
        String answer = "testAnswer";
        assertEquals(question , (new ShortAnswer(question,answer).toString()) );
    }
    @Test
    public void constructor_ValidArguments_ReturnsObject(){
        String question = "testQuestion";
        String answer = "testAnswer";
        assertNotNull(new ShortAnswer(question , answer));
    }
    @Test
    public void constructor_NullQuestionValidAnswer_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShortAnswer t = new ShortAnswer(null, "Good");
        });
    }
    @Test
    public void constructor_EmptyQuestionValidAnswer_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShortAnswer t = new ShortAnswer("", "Good");
        });
    }
    @Test
    public void constructor_NullAnswerValidQuestion_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShortAnswer t = new ShortAnswer("Good", null);
        });
    }
    @Test
    public void constructor_EmptyAnswerValidQuestion_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShortAnswer t = new ShortAnswer("good", "");
        });
    }
    @Test
    public void constructor_NullAnswerNullQuestion_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShortAnswer t = new ShortAnswer(null, null);
        });
    }
    @Test
    public void constructor_EmptyAnswerEmptyQuestion_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShortAnswer t = new ShortAnswer("", "");
        });
    }
}
