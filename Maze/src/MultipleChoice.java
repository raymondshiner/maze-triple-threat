import java.io.File;
import java.io.IOException;
import java.sql.*;

public class MultipleChoice extends Question{
    private Choices answerChoices;
    private String theCorrectAnswer;

    public MultipleChoice() {
        super();
    }

    public MultipleChoice(String [] choices){
        answerChoices = new Choices(choices[0], choices[1], choices[2], choices[3]);
    }

    void setPossibleAnswers() {
    }

    @Override
    public boolean checkAnswer(String toCheck) {
        return toCheck.equals(this.theCorrectAnswer);
    }

    private class Choices{
        private String choiceA, choiceB, choiceC, choiceD;

        Choices(String a, String b, String c, String d){
            setChoice("a", a);
            setChoice("b", b);
            setChoice("c", c);
            setChoice("d", d);
        }

        public String getChoiceA(){ return choiceA;}

        public String getChoiceB() { return choiceB;}

        public String getChoiceC(){ return choiceC;}

        public String getChoiceD(){ return choiceD;}

        void setChoice(String letter, String choice){
            if (choice == null) choice = "";
            switch(letter){
                case "a":
                    this.choiceA = choice;
                    break;
                case "b":
                    this.choiceB = choice;
                    break;
                case "c":
                    this.choiceC = choice;
                    break;
                    default: this.choiceD = choice;
            }
        }


    }
}
