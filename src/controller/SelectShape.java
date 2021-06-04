package controller;

import controller.interfaces.IUndoable;
import model.Box;
import model.StoredShapeLists;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class SelectShape implements IUndoable {
    private Point startP;
    private Point endP;
    private PaintCanvasBase paintCanvasBase;
    private IApplicationState appState;
    private Graphics2D graphics2D;

    public SelectShape(Point startP, Point endP, PaintCanvasBase paintCanvasBase, IApplicationState appState) {
        this.startP = startP;
        this.endP = endP;
        this.paintCanvasBase = paintCanvasBase;
        this.appState = appState;
        this.graphics2D = paintCanvasBase.getGraphics2D();
    }

    public void select() {
        StoredShapeLists.selectedShape.clear();
        Box box = new Box(startP, endP);
        for (Shape s : StoredShapeLists.addedShape) {
            if (box.findOverlap(s)) {
                StoredShapeLists.selectedShape.add(s);
            }

        }
        for (Shape s : StoredShapeLists.selectedShape) {
            graphics2D.setStroke(new BasicStroke(10));
            graphics2D.setColor(Color.BLACK);
            graphics2D.draw(s);
        }
        System.out.println("<<-- Shape selected - ShapeRepository.selectedCollection --- " + StoredShapeLists.selectedShape.toString());

    }
    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
