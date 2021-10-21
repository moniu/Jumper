package Engine;

public class GameObject extends MetaObject{
    MetaObject master;
    Scene scene;
    double localX, localY;

    public GameObject(Scene scene) {
        super(scene.game);
        this.scene = scene;
        this.localX = 0.0;
        this.localY = 0.0;
        this.master = null;
    }
    public final MetaObject getMaster() {
        return this.master;
    }
    public final void setMaster(GameObject master) {
        this.master.removeChild(this);
        this.master = master;
        master.addChild(this);
    }
    public final double getLocalX() {
        return this.localX;
    }
    public final void setLocalX(double x) {
        this.localX = x;
    }
    public final double getLocalY() {
        return this.localY;
    }
    public final void setLocalY(double y) {
        this.localY = y;
    }
    @Override
    public final double getGlobalX() {
        return master.getGlobalX() + this.localX;
    }
    @Override
    public final double getGlobalY() {
        return master.getGlobalY() + this.localY;
    }
    public void customTick(double deltaTime) {
        ;
    }

    public Scene getScene() {
        return scene;
    }
}
