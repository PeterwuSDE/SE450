package controller;

import controller.factories.ShapeTypeFactory;
import controller.interfaces.IUndoable;
import model.ShapeColor;
import model.ShapeProperty;
import model.ShapeShadingType;
import model.ShapeType;
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

        IDrawable drawable;

        if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            drawable = new outlineStrategy(shape, primaryColor, secondaryColor, graphics2D);
        }
        else if (shapeShadingType.equals(shapeShadingType.FILLED_IN)) {
            drawable = new filledInStrategy(shape, primaryColor, secondaryColor, graphics2D);
        }
        else if (shapeShadingType.equals(shapeShadingType.OUTLINE_AND_FILLED_IN)) {
            drawable = new outlineAndFilledInStrategy(shape, primaryColor, secondaryColor, graphics2D);
        }
    }
    public void createShape(ShapeProperty shapeProperty) {
        shape = ShapeTypeFactory.build(shapeProperty);
    }

    public void draw() {
        paintShape();
        paintCanvasBase.repaint();
    }


    /*@Override
    public void create() {
        //** Clear all selected shapes before drawing new shapes
        ShapeRepository.selectedCollection.clear();

        paintShapeOnCanvas();
        ShapeRepository.shapeCollection.add(this);
    }*/

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
