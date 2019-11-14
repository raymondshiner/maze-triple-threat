public abstract class Question {
    private String theQuestion;
    public Question(String input){
        this.theQuestion = input;
    }
    public abstract boolean checkAnswer(String toCheck);
    public String getQuestion(){
        return this.theQuestion;
    }




}
