package controller.commands;

import controller.interfaces.ICommand;
import model.undoRedo.Undo;

public class UndoCommand implements ICommand {

    private Undo undo;

    public UndoCommand(Undo undo) {
        this.undo = undo;
    }

    @Override
    public void run() {

    }
}
