package model.createStrategies;

import model.interfaces.ICreateShapeStrategy;

import java.awt.*;
import java.awt.geom.Path2D;

public class CreateTriangleStrategy implements ICreateShapeStrategy {

    private Point startP;
    private Point endP;

    public CreateTriangleStrategy(Point startP, Point endP) {
        this.startP = startP;
        this.endP = endP;
    }

    public Shape drawTriangle() {
        Path2D tri = new Path2D.Double();
        tri.moveTo(startP.x, startP.y);
        tri.lineTo(startP.x, endP.y);
        tri.lineTo(endP.x, endP.y);
        tri.closePath();
        return tri;
    }
    @Override
    public Shape create() {
        return drawTriangle();
    }
}
