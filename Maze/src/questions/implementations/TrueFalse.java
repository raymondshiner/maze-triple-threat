package questions.implementations;

import questions.Question;

public class TrueFalse extends Question {
    public TrueFalse(String theQuestion , String answer) {
        super(theQuestion, answer);
    }

    @Override
    public String toString(){
        return "True or False: \n" + super.toString();
    }
}
