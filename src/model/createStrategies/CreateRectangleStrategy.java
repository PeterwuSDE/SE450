package model.createStrategies;

import model.interfaces.ICreateShapeStrategy;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class CreateRectangleStrategy implements ICreateShapeStrategy {
    private int x;
    private int y;
    private int width;
    private int height;

    public CreateRectangleStrategy(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Shape create() {
        return new Rectangle2D.Double(x, y, width, height);
    }
}
