package controller.factories;

import model.ShapeProperty;
import model.ShapeShadingType;
import model.ShapeType;
import model.createStrategies.CreateEllipseStrategy;
import model.createStrategies.CreateTriangleStrategy;
import model.interfaces.ICreateShapeStrategy;
import model.createStrategies.CreateRectangleStrategy;

import javax.security.auth.login.CredentialException;
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
        Point startP = shapeProperty.getStartP();
        Point endP = shapeProperty.getEndP();
        ICreateShapeStrategy createShapeStrategy = null;

        switch (shapeType) {
            case RECTANGLE:
                createShapeStrategy = new CreateRectangleStrategy(x, y, width, height);
                break;
            case TRIANGLE:
                createShapeStrategy = new CreateTriangleStrategy(startP, endP);
                break;
            case ELLIPSE:
                createShapeStrategy = new CreateEllipseStrategy(x, y, width, height);
                break;
        }

        return createShapeStrategy.create();
    }



}
