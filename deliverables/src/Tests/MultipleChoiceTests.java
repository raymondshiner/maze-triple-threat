package Tests;

import org.junit.jupiter.api.Test;
import questions.implementations.MultipleChoice;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleChoiceTests {
    @Test
    public void constructor_validArguments_ReturnsObject() {
        String question = "testQuestion";
        String answer = "d";
        String[] possibleAnswers = {"theFirstWrong", "theSecondWrong", "theThirdWrong", "theCorrect"};
        assertNotNull( new MultipleChoice(question, possibleAnswers, answer).toString());
    }
    @Test
    public void constructor_NullAnswerA_ThrowsIllegalArgumentException() {
        String question = "testQuestion";
        String answer = "d";
        String[] possibleAnswers = {null, "theSecondWrong", "theThirdWrong", "theCorrect"};
        assertThrows(IllegalArgumentException.class, () -> {
            MultipleChoice t = new MultipleChoice(question, possibleAnswers, answer);
        });
    }
    @Test
    public void constructor_EmptyAnswerA_ThrowsIllegalArgumentException() {
        String question = "testQuestion";
        String answer = "d";
        String[] possibleAnswers = {"", "theSecondWrong", "theThirdWrong", "theCorrect"};
        assertThrows(IllegalArgumentException.class, () -> {
            MultipleChoice t = new MultipleChoice(question, possibleAnswers, answer);
        });
    }
    @Test
    public void constructor_NullAnswerB_ThrowsIllegalArgumentException() {
        String question = "testQuestion";
        String answer = "d";
        String[] possibleAnswers = {"theFirstWrong", null, "theThirdWrong", "theCorrect"};
        assertThrows(IllegalArgumentException.class, () -> {
            MultipleChoice t = new MultipleChoice(question, possibleAnswers, answer);
        });
    }
    @Test
    public void constructor_EmptyAnswerB_ThrowsIllegalArgumentException() {
        String question = "testQuestion";
        String answer = "d";
        String[] possibleAnswers = {"theFirstWrong", "", "theThirdWrong", "theCorrect"};
        assertThrows(IllegalArgumentException.class, () -> {
            MultipleChoice t = new MultipleChoice(question, possibleAnswers, answer);
        });
    }
    @Test
    public void constructor_NullAnswerC_ThrowsIllegalArgumentException() {
        String question = "testQuestion";
        String answer = "d";
        String[] possibleAnswers = {"theFirstWrong","theSecondWrong", null, "theCorrect"};
        assertThrows(IllegalArgumentException.class, () -> {
            MultipleChoice t = new MultipleChoice(question, possibleAnswers, answer);
        });
    }
    @Test
    public void constructor_EmptyAnswerC_ThrowsIllegalArgumentException() {
        String question = "testQuestion";
        String answer = "d";
        String[] possibleAnswers = {"theFirstWrong","theSecondWrong", "", "theCorrect"};
        assertThrows(IllegalArgumentException.class, () -> {
            MultipleChoice t = new MultipleChoice(question, possibleAnswers, answer);
        });
    }
    @Test
    public void constructor_NullAnswerD_ThrowsIllegalArgumentException() {
        String question = "testQuestion";
        String answer = "d";
        String[] possibleAnswers = {"theFirstWrong","theSecondWrong", "theThirdWrong", null};
        assertThrows(IllegalArgumentException.class, () -> {
            MultipleChoice t = new MultipleChoice(question, possibleAnswers, answer);
        });
    }
    @Test
    public void constructor_EmptyAnswerD_ThrowsIllegalArgumentException() {
        String question = "testQuestion";
        String answer = "d";
        String[] possibleAnswers = {"theFirstWrong","theSecondWrong", "theThirdWrong", ""};
        assertThrows(IllegalArgumentException.class, () -> {
            MultipleChoice t = new MultipleChoice(question, possibleAnswers, answer);
        });
    }
    @Test
    public void toString_validArguments_ReturnsString() {
        String question = "testQuestion";
        String answer = "d";
        String[] possibleAnswers = {"theFirstWrong", "theSecondWrong", "theThirdWrong", "theCorrect"};
        assertEquals(question + "\n" + "a - " + "theFirstWrong" + "\n" + "b - " + "theSecondWrong" + "\n" + "c - " + "theThirdWrong" + "\n" + "d - " + "theCorrect" + "\n", new MultipleChoice(question, possibleAnswers, answer).toString());
    }
    


}
