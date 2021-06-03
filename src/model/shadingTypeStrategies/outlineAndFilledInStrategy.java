package model.shadingTypeStrategies;

import model.ShapeColor;
import model.ShapeProperty;
import model.ShapeType;
import model.interfaces.IDrawable;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class outlineAndFilledInStrategy implements IDrawable {
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private Shape shape;
    private PaintCanvasBase paintCanvasBase;
    private Graphics2D graphics2D;
    private ShapeProperty shapeProperty;
    private ShapeType shapeType;

    public outlineAndFilledInStrategy (Shape shape, ShapeColor primaryColor, ShapeColor secondaryColor, Graphics2D graphics2D) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shape = shape;
        this.graphics2D = paintCanvasBase.getGraphics2D();
    }

    @Override
    public void paintShape() {
        graphics2D.setColor(primaryColor.getColor());
        graphics2D.draw(shape);
        graphics2D.setColor(secondaryColor.getColor());
        graphics2D.fill(shape);
    }
}
