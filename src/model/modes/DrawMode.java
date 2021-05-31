package model.modes;

import controller.DrawShape;
import controller.commands.DrawShapeCommand;
import model.ShapeColor;
import model.ShapeProperty;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.interfaces.IMode;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawMode implements IMode {
    private Point startP;
    private Point endP;
    private PaintCanvasBase paintCanvasBase;
    private IApplicationState appState;
    private ShapeProperty shapeProperty;

    public DrawMode(Point startP, Point endP, PaintCanvasBase paintCanvasBase, IApplicationState appState) {
        this.startP = startP;
        this.endP = endP;
        this.paintCanvasBase = paintCanvasBase;
        this.appState = appState;

        ShapeType shapeType = appState.getActiveShapeType();
        ShapeShadingType shapeShadingType = appState.getActiveShapeShadingType();
        ShapeColor primaryColor = appState.getActivePrimaryColor();
        ShapeColor secondaryColor = appState.getActiveSecondaryColor();

        shapeProperty = new ShapeProperty(startP,endP);
        shapeProperty.setShapeShadingType(shapeShadingType);
        shapeProperty.setShapeType(shapeType);
        shapeProperty.setPrimaryColor(primaryColor);
        shapeProperty.setSecondaryColor(secondaryColor);
    }



    @Override
    public void execute() {
        DrawShape drawShape = new DrawShape(paintCanvasBase, shapeProperty);
        DrawShapeCommand drawShapeCommand = new DrawShapeCommand(drawShape);
        drawShapeCommand.run();
    }
}
