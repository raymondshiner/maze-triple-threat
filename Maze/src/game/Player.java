package game;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;

    public Player(){
        this.name = "NO NAME";
    }

    public void setName(String name)
    {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Player.setName - name cannot be empty or null");

        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
}
