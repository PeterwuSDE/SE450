package model;

import model.interfaces.IShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Box {
    Point startP;
    Point endP;

    public Box(Point startP, Point endP) {
        this.startP = startP;
        this.endP = endP;
    }

    public boolean findOverlap(IShape shape) {
        boolean res = false;

        ShapeProperty shapeProperty = shape.getShapeProperty();
        int sX = shapeProperty.getX();
        int sY = shapeProperty.getY();
        int sWidth = shapeProperty.getWidth();
        int sHeight = shapeProperty.getHeight();

        int minX = Math.min(startP.x, endP.x);
        int minY = Math.min(startP.y, endP.y);
        int maxX = Math.max(startP.x, endP.x);
        int maxY = Math.max(startP.y, endP.y);

        if (minX < sX + sWidth &&
                minX + (maxX - minX) > sX &&
                minY < sY + sHeight &&
                minY + (maxY - minY) > sY) {
            res = true;
        }
        /*Rectangle2D rect = shape.getBounds2D();



        int width = maxX - minX;
        int height = maxY - minY;

        if (minX < rect.getMinX() + rect.getWidth() &&
                minX + (maxX - minX) > rect.getMinX() &&
                minY < rect.getMinY() + rect.getHeight() &&
                minY + (maxY - minY) > rect.getMinY()) {

            res = true;
        }
        /*Point p1 = new Point(startP.x, startP.y);
        Point p2 = new Point(startP.x, endP.y);
        Point p3 = new Point(endP.x, startP.y);
        Point p4 = new Point(endP.x, endP.y);

        ArrayList<Point> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);
        for (Point p : pList) {
            if ((p.getX() <= maxX && p.getX() >= minX) && (p.getY() <= maxY && p.getY() >= minY)) {
                res = true;
            }
        }*/

        return res;
    }
}
