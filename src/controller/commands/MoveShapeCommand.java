package controller.commands;

import controller.MoveShape;
import controller.interfaces.ICommand;

public class MoveShapeCommand implements ICommand {
    public MoveShape moveShape;

    public MoveShapeCommand(MoveShape moveShape) {
        this.moveShape = moveShape;
    }

    @Override
    public void run() {
        moveShape.move();
    }
}
