package Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import questions.implementations.TrueFalse;

public class TrueFalseTests {
    @Test
    public void constructor_Good_arguments(){
        String question = "testQuestion";
        String answer = "testAnswer";
        assertEquals("True or False: \n" + question , (new TrueFalse(question,answer).toString()) );
    }
}
