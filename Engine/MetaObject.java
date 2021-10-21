package Engine;

import java.util.ArrayList;


public abstract class MetaObject {
    ArrayList<GameObject> childrenGameObjects;
    Game game;

    public MetaObject(Game game) {
        this.game = game;
        childrenGameObjects = new ArrayList<GameObject>();
    }

    public double getGlobalX() {
        return 0.0;
    }
    public double getGlobalY() {
        return 0.0;
    }

    public final void addChild(GameObject child) {
        this.childrenGameObjects.add(child);
        child.master = this;
    }
    public final void removeChild(GameObject child) {
        child.removeAllChildren();
        this.childrenGameObjects.remove(child);
    }
    public final void removeAllChildren() {
        this.childrenGameObjects.clear();
    }
    public final ArrayList<GameObject> getChildren() {
        return this.childrenGameObjects;
    }
    public final void tick(double deltaTime) {
        this.customTick(deltaTime);
        for(int i=0;i<childrenGameObjects.size();i++) {
            childrenGameObjects.get(i).tick(deltaTime);
        }
    }
    public void customTick(double deltaTime) {
        ;
    }
    public final Game getGame() {
        return game;
    }
}
