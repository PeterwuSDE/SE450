package controller.commands;

import controller.DrawShape;
import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;

public class DrawShapeCommand implements ICommand, IUndoable {

    private DrawShape drawShape;

    public DrawShapeCommand(DrawShape drawShape) {
        this.drawShape = drawShape;
    }

    @Override
    public void run() {
        drawShape.draw();
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
