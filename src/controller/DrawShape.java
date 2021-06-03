package controller;

import controller.factories.ShapeTypeFactory;
import controller.interfaces.IUndoable;
import model.*;
import model.interfaces.IApplicationState;
import model.interfaces.IDrawable;
import model.shadingTypeStrategies.filledInStrategy;
import model.shadingTypeStrategies.outlineAndFilledInStrategy;
import model.shadingTypeStrategies.outlineStrategy;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawShape implements IUndoable {

    private PaintCanvasBase paintCanvasBase;
    private IApplicationState appState;
    private ShapeProperty shapeProperty;
    private Graphics2D graphics2D;
    private Shape shape;


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

        IDrawable drawable = null;

        switch (shapeShadingType) {
            case OUTLINE:
                drawable = new outlineStrategy(shape, primaryColor, secondaryColor, graphics2D);
                break;
            case FILLED_IN:
                drawable = new filledInStrategy(shape, primaryColor, secondaryColor, graphics2D);
                break;
            case OUTLINE_AND_FILLED_IN:
                drawable = new outlineAndFilledInStrategy(shape, primaryColor, secondaryColor, graphics2D);
                break;
        }
        /*if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            drawable = new outlineStrategy(shape, primaryColor, secondaryColor, graphics2D);
        }
        else if (shapeShadingType.equals(shapeShadingType.FILLED_IN)) {
            drawable = new filledInStrategy(shape, primaryColor, secondaryColor, graphics2D);
        }
        else if (shapeShadingType.equals(shapeShadingType.OUTLINE_AND_FILLED_IN)) {
            drawable = new outlineAndFilledInStrategy(shape, primaryColor, secondaryColor, graphics2D);
        }*/

        drawable.paintShape();
    }
    public void createShape(ShapeProperty shapeProperty) {
        shape = ShapeTypeFactory.build(shapeProperty);
    }

    public void draw() {
        /*StoredShapeLists.addedShape.add(shape);
        paintShape();*/
        //paintCanvasBase.repaint();
        newShape();
        //paintCanvasBase.repaint();
    }


    public void newShape() {
        paintShape();
        StoredShapeLists.addedShape.add(shape);
    }
    @Override
    public void undo() {
        StoredShapeLists.addedShape.remove(StoredShapeLists.addedShape.size() - 1);

    }

    @Override
    public void redo() {

    }
}
