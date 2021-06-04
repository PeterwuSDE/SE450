package model.interfaces;

import model.ShapeProperty;

import java.awt.*;

public interface IShape {

    ShapeProperty getShapeProperty();
    Shape getShape();
    void deleteShape();

}
