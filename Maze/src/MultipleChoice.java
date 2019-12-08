import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.*;

public class MultipleChoice extends Question{
    private Choices answerChoices;


    public MultipleChoice() {
        super();
    }

    public MultipleChoice(String question , String [] choices , String answer){
        super(question, answer);
        answerChoices = new Choices(choices[0], choices[1], choices[2], choices[3]);
    }


    @Override
    public String toString(){
        return super.toString() + "\n" + answerChoices.toString();
    }
    private class Choices implements Serializable{
        private String choiceA, choiceB, choiceC, choiceD;
        // this will have to be random or the correct answer will always be A
        // but do not currently care because it works and will work for deployment
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

        @Override
        public String toString(){
            return "a - " + getChoiceA() + "\n" + "b - " + getChoiceB() + "\n" + "c - " + getChoiceC() + "\n" + "d - " +getChoiceD() + "\n";
        }
    }
}
