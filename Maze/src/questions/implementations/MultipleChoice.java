package questions.implementations;

import questions.Question;

import java.io.Serializable;

public class MultipleChoice extends Question {
    private Choices answerChoices;

    public MultipleChoice(String question , String [] choices , String answer){
        super(question, answer);
        if(choices.length != 4 || choices[0] == null || choices[1] == null || choices[2] == null || choices[3] == null || choices[0].equals("") || choices[1].equals("") || choices[2].equals("") || choices[3].equals("") )
        {
            throw new IllegalArgumentException("Multiple Choice constructor - neither question nor correct answer or the answers can be null or empty");
        }
        answerChoices = new Choices(choices[0], choices[1], choices[2], choices[3]);
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + answerChoices.toString();
    }

    private class Choices implements Serializable{
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

        @Override
        public String toString(){
            return "a - " + getChoiceA() + "\n" + "b - " + getChoiceB() + "\n" + "c - " + getChoiceC() + "\n" + "d - " +getChoiceD() + "\n";
        }
    }
}
