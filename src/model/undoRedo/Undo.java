package model.undoRedo;

import java.awt.*;

public class Undo {
    private Shape shape;

    public Undo(Shape shape) {
        this.shape = shape;
    }

    public void execute() {
        //CommandHistory.undo();
        //paintObservable.notifyUpdate();
    }
}
