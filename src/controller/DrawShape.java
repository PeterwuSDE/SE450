package controller;

import model.ShapeColor;
import model.ShapeProperty;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawShape {

    private PaintCanvasBase paintCanvasBase;
    private IApplicationState appState;
    private ShapeProperty shapeProperty;
    private Graphics2D graphics2D;

    public DrawShape(PaintCanvasBase paintCanvasBase, ShapeProperty shapeProperty) {
        this.paintCanvasBase = paintCanvasBase;
        this.shapeProperty = shapeProperty;
        this.graphics2D = paintCanvasBase.getGraphics2D();

        createShape(shapeProperty);
    }

    public void paintShape() {
        ShapeShadingType shapeShadingType = shapeProperty.getShapeShadingType();
        ShapeColor primaryColor = shapeProperty.getPrimaryColor();
        ShapeColor secondaryColor = shapeProperty.getSecondaryColor();

        if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {

        }
        else if (shapeShadingType.equals(shapeShadingType.FILLED_IN)) {

        }
        else if (shapeShadingType.equals(shapeShadingType.OUTLINE_AND_FILLED_IN)) {

        }
    }
    public void createShape(ShapeProperty shapeProperty) {

    }

    public void draw() {

    }

}
