public class ShortAnswer extends Question {
    private String theAnswer;
    public ShortAnswer(String theQuestion , String theAnswer) {
        super(theQuestion);
    }

    @Override
    public boolean checkAnswer(String toCheck) {
        return false;
    }
    // does not need to override the toString method because it will just call the super.toString method and return that and add nothing to it
}
