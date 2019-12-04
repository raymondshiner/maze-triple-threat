import java.io.Serializable;

public class Door implements IBarrier , Serializable {
    private boolean isLocked;
    private boolean isOpen;
    private Question question;

    public Door(){
        //to start doors are always closed but not locked yet
        // when a question is answered they will either open or lock

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
