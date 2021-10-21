package Engine;

import java.awt.Color;
import java.util.ArrayList;

public class Scene extends MetaObject{
    protected ArrayList<GraphicObject> graphicObjects;
    protected ArrayList<PhysicalObject> physicalObjects;
    protected Camera camera;
    protected Color backgroundColor;

    public Scene(Game game) {
        super(game);
        graphicObjects = new ArrayList<GraphicObject>();
        physicalObjects = new ArrayList<PhysicalObject>();
        camera = new Camera(0.0, 0.0, 1.0);
        backgroundColor = Color.WHITE;
    }

    public ArrayList<GraphicObject> getGraphicObjects() {
        return this.graphicObjects;
    }
    public void setGraphicObjects(ArrayList<GraphicObject> graphicObjects) {
        this.graphicObjects = graphicObjects;
    }

    public ArrayList<PhysicalObject> getPhysicalObjects() {
        return this.physicalObjects;
    }
    public void setPhysicalObjects(ArrayList<PhysicalObject> physicalObjects) {
        this.physicalObjects = physicalObjects;
    }

    public Camera getCamera() {
        return this.camera;
    }
    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    public boolean registerGraphicObject(GraphicObject graphicObject) {
        synchronized(physicalObjects) {
            if (this.graphicObjects.contains(graphicObject)) {
                return false;
            }
            this.graphicObjects.add(graphicObject);
            return true;
        }
    }

    public boolean registerPhysicalObject(PhysicalObject physicalObject) {
        synchronized(physicalObjects) {
            if (this.physicalObjects.contains(physicalObject)) {
                return false;
            }
            this.physicalObjects.add(physicalObject);
            return true;
        }
    }

    public boolean unregisterPhysicalObject(PhysicalObject physicalObject) {
        synchronized(physicalObjects) {
            if (!this.physicalObjects.contains(physicalObject)) {
                return false;
            }
            this.physicalObjects.remove(physicalObject);
            return true;
        }
    }

    public boolean unregisterGraphicObject(GraphicObject graphicObject) {
        synchronized(physicalObjects) {
            if (!this.graphicObjects.contains(graphicObject)) {
                return false;
            }
            this.graphicObjects.remove(graphicObject);
            return true;
        }
    }

    public final MetaObject getMaster() {
        return this;
    }
}