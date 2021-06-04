package controller;

import controller.interfaces.IUndoable;
import model.Box;
import model.ShapeProperty;
import model.StoredShapeLists;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
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
        StoredShapeLists.selectedIShape.clear();
        Box box = new Box(startP, endP);
        for (IShape s : StoredShapeLists.addedIShape) {
            if (box.findOverlap(s)) {
                StoredShapeLists.selectedIShape.add(s);
                //System.out.println(1);
            }

        }
        for (IShape s : StoredShapeLists.selectedIShape) {
            ShapeProperty shapeProperty = s.getShapeProperty();
            graphics2D.setStroke(new BasicStroke(10));
            graphics2D.setColor(Color.BLACK);
            graphics2D.draw(s.getShape());
        }

    }
    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
