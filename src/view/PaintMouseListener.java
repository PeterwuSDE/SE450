package view;

import model.MouseMode;
import model.interfaces.IApplicationState;
import model.interfaces.IMode;
import model.modes.DrawMode;
import model.modes.MoveMode;
import model.modes.SelectMode;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaintMouseListener implements MouseListener {

    private PaintCanvasBase paintCanvasBase;
    private Point startP, endP;
    private IApplicationState appState;
    private IMode mode;

    public PaintMouseListener(PaintCanvasBase paintCanvasBase, IApplicationState appState) {
        this.paintCanvasBase = paintCanvasBase;
        this.appState = appState;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startP = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endP = e.getPoint();
        MouseMode mouseMode = appState.getActiveMouseMode();
        switch (mouseMode) {
            case DRAW:
                mode = new DrawMode(startP, endP, paintCanvasBase, appState);
                break;
            case MOVE:
                mode = new MoveMode(startP, endP, paintCanvasBase, appState);
                break;
            case SELECT:
                mode = new SelectMode(startP, endP, paintCanvasBase, appState);
                break;
        }
        //mode = new DrawMode(startP, endP, paintCanvasBase, appState);
        mode.execute();
        //System.out.println(e.getX() + "   " + e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
