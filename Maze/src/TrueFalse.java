public class TrueFalse extends Question {
    private String theAnswer;
    public TrueFalse(String theQuestion , String answer) {
        super(theQuestion);
        theAnswer = answer;

    }
    @Override
    public boolean checkAnswer(String toCheck) {
        if(super.checkAnswer(toCheck))
            return true;

        return theAnswer.equalsIgnoreCase(toString());
    }
    @Override
    public String toString(){
        return "True or False " + super.toString();
    }
}
