package model;

import java.awt.*;

public class ShapeProperty {
    private Point startP;
    private Point endP;
    private ShapeType shapeType;
    private ShapeShadingType shapeShadingType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private int width;
    private int height;
    private int x; //x coordinate of the shape
    private int y;  //y coordinate of the shape

    public ShapeProperty(Point startP, Point endP) {
        this.startP = startP;
        this.endP = endP;

        this.shapeType = ShapeType.RECTANGLE;
        this.shapeShadingType = ShapeShadingType.OUTLINE;
        this.primaryColor = ShapeColor.GREEN;
        this.secondaryColor = ShapeColor.BLUE;

        calculate(startP, endP);
    }

    public void calculate (Point startP, Point endP) {
        width = Math.abs(startP.x - endP.x);
        height = Math.abs(startP.y - endP.y);
        x = Math.min(startP.x, endP.x);
        y = Math.min(startP.y, endP.y);
    }

    public Point getStartP() {
        return startP;
    }

    public void setStartP(Point startP) {
        this.startP = startP;
    }

    public Point getEndP() {
        return endP;
    }

    public void setEndP(Point endP) {
        this.endP = endP;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public ShapeShadingType getShapeShadingType() {
        return shapeShadingType;
    }

    public void setShapeShadingType(ShapeShadingType shapeShadingType) {
        this.shapeShadingType = shapeShadingType;
    }

    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(ShapeColor primaryColor) {
        this.primaryColor = primaryColor;
    }

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
