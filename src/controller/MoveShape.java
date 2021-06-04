package controller;

import model.ShapeProperty;
import model.StoredShapeLists;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MoveShape {
    private int offX;
    private int offY;
    private PaintCanvasBase paintCanvasBase;
    private Graphics2D graphics2D;

    public MoveShape(int offX, int offY, PaintCanvasBase paintCanvasBase) {
        this.offX = offX;
        this.offY = offY;
        this.paintCanvasBase = paintCanvasBase;
        this.graphics2D = paintCanvasBase.getGraphics2D();
    }

    public void move() {
        for (IShape s : StoredShapeLists.selectedIShape) {
            /*Rectangle2D box = s.getBounds2D();
            double x = box.getX();
            double y = box.getY();
            double newX = x + offX;
            double newY = y + offY;
            double width = box.getWidth();
            double height = box.getHeight();*/
            ShapeProperty shapeProperty = s.getShapeProperty();
            int x = shapeProperty.getX();
            int y = shapeProperty.getY();
            shapeProperty.setX(x + offX);
            shapeProperty.setY(y + offY);
            DrawShape drawShape = new DrawShape(paintCanvasBase,shapeProperty);
            drawShape.draw();
            s.deleteShape();
        }
    }
}
