package controller.factories;

import model.ShapeProperty;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.ICreateShapeStrategy;
import model.createStrategies.CreateRectangleStrategy;

import java.awt.*;

import static model.ShapeType.*;

public class ShapeTypeFactory {

    public static Shape build(ShapeProperty shapeProperty) {
        ShapeType shapeType = shapeProperty.getShapeType();
        ShapeShadingType shapeShadingType = shapeProperty.getShapeShadingType();
        int x = shapeProperty.getX();
        int y = shapeProperty.getY();
        int width = shapeProperty.getWidth();
        int height = shapeProperty.getHeight();
        ICreateShapeStrategy createShapeStrategy = null;

        switch (shapeType) {
            case RECTANGLE:
                createShapeStrategy = new CreateRectangleStrategy(x, y, width, height);
                break;
            case TRIANGLE:
                createShapeStrategy = new CreateRectangleStrategy(x, y, width, height);
                break;
            case ELLIPSE:
                createShapeStrategy = new CreateRectangleStrategy(x, y, width, height);
                break;
        }

        return createShapeStrategy.create();
    }



}
