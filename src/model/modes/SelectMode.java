package model.modes;

import model.interfaces.IApplicationState;
import model.interfaces.IMode;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class SelectMode implements IMode {
    private Point startP;
    private Point endP;
    private PaintCanvasBase paintCanvasBase;
    private IApplicationState appState;

    public SelectMode(Point startP, Point endP, PaintCanvasBase paintCanvasBase, IApplicationState appState) {
        this.startP = startP;
        this.endP = endP;
        this.paintCanvasBase = paintCanvasBase;
        this.appState = appState;
    }

    @Override
    public void execute() {

    }
}
