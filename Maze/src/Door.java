public class Door implements IBarrier {
    private boolean isLocked;
    private boolean isOpen;
    private Question question;

    public Door(){
        this.isLocked = false;
        this.isOpen = false;
        //to start doors are always closed but not isLocked yet
        // when a question is answered they will either isOpen or lock

    }
    public boolean canOpen(){
        return false;
    }
    public Question getQuestion(){
        return null;
    }
    public boolean isOpen(){
        return this.isOpen;
    }
    public boolean isLocked(){
        return this.isLocked;
    }
    public void open(){
        this.isOpen = true;
    }
    public void lock(){
        this.isLocked = true;
    }


    @Override
    public boolean isAWall() {
        return false;
    }
}
