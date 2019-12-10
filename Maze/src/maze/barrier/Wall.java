package maze.barrier;

import maze.barrier.IBarrier;

import java.io.Serializable;

public class Wall implements IBarrier, Serializable {

    @Override
    public boolean isAWall() {
        return true;
    }
}
