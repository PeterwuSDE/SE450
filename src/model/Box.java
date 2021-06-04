package model;

import java.awt.*;
import java.util.ArrayList;

public class Box {
    Point startP;
    Point endP;

    public Box(Point startP, Point endP) {
        this.startP = startP;
        this.endP = endP;
    }

    public boolean findOverlap(Shape shape) {
        boolean res = false;

        int minX = Math.min(startP.x, endP.x);
        int minY = Math.min(startP.y, endP.y);
        int maxX = Math.max(startP.x, endP.x);
        int maxY = Math.max(startP.y, endP.y);

        Point p1 = new Point(startP.x, startP.y);
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
        }

        return res;
    }
}
