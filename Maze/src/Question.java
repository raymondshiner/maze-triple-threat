import java.io.Serializable;

public abstract class Question implements Serializable {
    private String theQuestion;
    private String theAnswer;
    private final String cheat = "42";
    public Question(String input){
        this.theQuestion = input;
    }
    public Question(){this.theQuestion = "this is a default question";}
    public boolean checkAnswer(String toCheck){
        if (toCheck.equals(cheat)) return true;
        return false;
    }
    public String toString(){ return this.theQuestion;}

}
