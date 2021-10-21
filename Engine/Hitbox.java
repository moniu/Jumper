package Engine;

public abstract class Hitbox extends GameObject{
    public Hitbox(Scene scene) {
        super(scene);
    }

    public String shape;
    private PhysicalObject physicalObject;
    public abstract boolean checkCollision(Hitbox hb);
    public String getShape() {
        return shape;
    }

    public PhysicalObject getPhysicalObject() {
        return this.physicalObject;
    }

    public void setPhysicalObject(PhysicalObject physicalObject) {
        this.physicalObject = physicalObject;
        physicalObject.setHitbox(this);
    }
}
