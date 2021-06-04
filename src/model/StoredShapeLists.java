package model;

import model.interfaces.IShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoredShapeLists {

    public static final List<Shape> addedShape = new ArrayList<>();
    public static final List<Shape> selectedShape = new ArrayList<>();
    public static final HashMap<Shape, IShape> shapeToIShape = new HashMap<>();
    public static final List<IShape> selectedIShape = new ArrayList<>();
    public static final List<IShape> addedIShape = new ArrayList<>();

}
