public class MultipleChoice extends Question{
    private String [] thePossibleAnswers;
    private String theCorrectAnswer;
    public MultipleChoice(){
        super();
        this.thePossibleAnswers = new String[4];
        this.thePossibleAnswers[0] = "1";
        this.thePossibleAnswers[1] = "2";
        this.thePossibleAnswers[2] = "3";
        this.thePossibleAnswers[3] = "42";
        this.theCorrectAnswer = "42";

    }
    @Override
    public boolean checkAnswer(String toCheck) {
        return toCheck.equals(this.theCorrectAnswer);
    }
}
