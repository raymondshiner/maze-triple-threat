public class TrueFalse extends Question {
    private String theAnswer;
    public TrueFalse(String theQuestion , String answer) {
        super(theQuestion, answer);

    }

    @Override
    public String toString(){
        return "True or False: \n" + super.toString();
    }
}
