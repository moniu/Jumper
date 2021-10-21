package Engine;

public class RectangleHitbox extends Hitbox{
    private double sizeX, sizeY;
    private PhysicalObject physicalObject;

    public RectangleHitbox(Scene scene, double sizeX, double sizeY) {
        super(scene);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.shape = "RECTANGLE";
    }
    @Override
    public boolean checkCollision(Hitbox hb) {
        if (hb == this){
            return false;
        }
        if (hb.getShape() == "RECTANGLE") {
            RectangleHitbox rHitbox = (RectangleHitbox) hb;
            double leftMargin, rightMargin, topMargin, bottomMargin;
            leftMargin = rHitbox.getGlobalX() - rHitbox.getSizeX()/2;
            rightMargin = rHitbox.getGlobalX() + rHitbox.getSizeX()/2;
            topMargin = rHitbox.getGlobalY() - rHitbox.getSizeY()/2;
            bottomMargin = rHitbox.getGlobalY() + rHitbox.getSizeY()/2;

            double leftPos, rightPos, topPos, bottomPos;
            leftPos = getGlobalX() - sizeX/2;
            rightPos = getGlobalX() + sizeX/2;
            topPos = getGlobalY() - sizeY/2;
            bottomPos = getGlobalY() + sizeY/2;


            if (leftPos <= rightMargin &&
            rightPos >= leftMargin &&
            topPos <= bottomMargin &&
            bottomPos >= topMargin) {
                return true;
            }
            return false;

        }
        return false;
    }

    public double getSizeX() {
        return this.sizeX;
    }

    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }

    public double getSizeY() {
        return this.sizeY;
    }

    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    public PhysicalObject getPhysicalObject() {
        return this.physicalObject;
    }

    public void setPhysicalObject(PhysicalObject physicalObject) {
        this.physicalObject = physicalObject;
    }
    
}
