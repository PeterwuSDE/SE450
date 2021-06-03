package model.shadingTypeStrategies;

import model.ShapeColor;
import model.ShapeProperty;
import model.ShapeType;
import model.interfaces.IDrawable;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class outlineStrategy implements IDrawable {
    private Shape shape;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private PaintCanvasBase paintCanvasBase;
    private Graphics2D graphics2D;
    private ShapeProperty shapeProperty;
    private ShapeType shapeType;

    public outlineStrategy(Shape shape, ShapeColor primaryColor, ShapeColor secondaryColor, Graphics2D graphics2D) {
        this.shape = shape;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.graphics2D = graphics2D;
    }

    @Override
    public void paintShape() {
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(primaryColor.getColor());
        graphics2D.draw(shape);
    }
}
