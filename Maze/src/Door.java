public class Door {
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
        // this in UML is setClosed change UML to match this better name
    }
    public void lock(){
        // not in UML yet
    }



}
