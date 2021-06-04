package controller.commands;

import controller.SelectShape;
import controller.interfaces.ICommand;

public class SelectShapeCommand implements ICommand {
    private SelectShape selectShape;

    public SelectShapeCommand(SelectShape selectShape) {
        this.selectShape = selectShape;
    }

    @Override
    public void run() {
        selectShape.select();
    }
}
