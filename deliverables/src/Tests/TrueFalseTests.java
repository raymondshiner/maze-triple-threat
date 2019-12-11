package Tests;

import Tests.mockObjects.TestableQuestion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import questions.implementations.TrueFalse;

public class TrueFalseTests {
    @Test
    public void toString_validArguments_ReturnsString(){
        String question = "testQuestion";
        String answer = "testAnswer";
        assertEquals("True or False: \n" + question , (new TrueFalse(question,answer).toString()) );
    }
    @Test
    public void constructor_ValidArguments_ReturnsObject(){
        String question = "testQuestion";
        String answer = "testAnswer";
        assertNotNull(new TrueFalse(question , answer));
    }
    @Test
    public void constructor_NullQuestionValidAnswer_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            TrueFalse t = new TrueFalse(null, "Good");
        });
    }
    @Test
    public void constructor_EmptyQuestionValidAnswer_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            TrueFalse t = new TrueFalse("", "Good");
        });
    }
    @Test
    public void constructor_NullAnswerValidQuestion_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            TrueFalse t = new TrueFalse("Good", null);
        });
    }
    @Test
    public void constructor_EmptyAnswerValidQuestion_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            TrueFalse t = new TrueFalse("good", "");
        });
    }
    @Test
    public void constructor_NullAnswerNullQuestion_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            TrueFalse t = new TrueFalse(null, null);
        });
    }
    @Test
    public void constructor_EmptyAnswerEmptyQuestion_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            TrueFalse t = new TrueFalse("", "");
        });
    }
}
