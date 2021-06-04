package model.modes;

import controller.DrawShape;
import controller.MoveShape;
import controller.commands.DrawShapeCommand;
import controller.commands.MoveShapeCommand;
import model.ShapeProperty;
import model.interfaces.IApplicationState;
import model.interfaces.IMode;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class MoveMode implements IMode {
    private Point startP;
    private Point endP;
    private IApplicationState appState;
    private PaintCanvasBase paintCanvasBase;
    private ShapeProperty shapeProperty;
    private int offX;
    private int offY;

    public MoveMode(Point startP, Point endP, PaintCanvasBase paintCanvasBase, IApplicationState appState) {
        this.startP = startP;
        this.endP = endP;
        this.appState = appState;
        this.paintCanvasBase = paintCanvasBase;
        offX = endP.x - startP.x;
        offY = endP.y - startP.y;
    }

    @Override
    public void execute() {
        MoveShape moveShape = new MoveShape(offX, offY, paintCanvasBase);
        MoveShapeCommand moveShapeCommand = new MoveShapeCommand(moveShape);
        moveShapeCommand.run();
    }
}
