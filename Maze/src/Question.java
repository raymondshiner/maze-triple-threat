public abstract class Question {
    private String theQuestion;
    public Question(){
        this.theQuestion = "this is a test question and the answer is 42";
    }
    public abstract boolean checkAnswer(String toCheck);
    public String getQuestion(){
        return this.theQuestion;
    }




}
