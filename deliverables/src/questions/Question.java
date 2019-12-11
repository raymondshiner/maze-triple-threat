package questions;

import java.io.Serializable;

public abstract class Question implements Serializable {
    private String theQuestion;
    private String theAnswer;
    private final String cheat = "42";
    public Question(String input, String answer){
        if(input == null || answer == null || input.isEmpty() || answer.isEmpty())
        {
            throw new IllegalArgumentException("Question constructor - neither question nor answer can be null or empty");
        }

        this.theQuestion = input;
        this.theAnswer = answer;
    }
    public boolean checkAnswer(String toCheck){
        if(toCheck == null)
            return false;

        if (toCheck.equals(cheat) || toCheck.equalsIgnoreCase(theAnswer)) return true;
        return false;
    }
    public String toString(){ return this.theQuestion;}
    public String getAnswer()
    {
        return theAnswer;
    }

}
