package model.createStrategies;

import model.interfaces.ICreateShapeStrategy;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CreateEllipseStrategy implements ICreateShapeStrategy {
    private int x;
    private int y;
    private int width;
    private int height;

    public CreateEllipseStrategy(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public Shape create() {
        return new Ellipse2D.Double(x, y, width, height);
    }
}
