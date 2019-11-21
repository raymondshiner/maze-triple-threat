public class Door implements IBarrier {
    private boolean locked;
    private boolean closed;
    private Question question;

    public Door(){
        this.locked = false;
        this.closed = true;
        //to start doors are always closed but not locked yet
        // when a question is answered they will either open or lock

    }
    public boolean canOpen(){
        return false;
    }
    public Question getQuestion(){
        return null;
    }
    public boolean isClosed(){
        return this.closed;
    }
    public boolean isLocked(){
        return this.locked;
    }
    public void open(){
        this.closed = false;
    }
    public void lock(){
        this.locked = true;
    }


    @Override
    public boolean isAWall() {
        return false;
    }
}
