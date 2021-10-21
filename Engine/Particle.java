package Engine;

public abstract class Particle extends GameObject{
    //protected GraphicObject graphicObject;
    protected double lifeSpan;
    protected double livedFor;
    public Particle(Scene scene) {
        super(scene);
    }

    public void kill() {
        removeAllChildren();
        //getScene().unregisterGraphicObject(graphicObject);
        getMaster().removeChild(this);
    }

    public double getLifeSpan() {
        return this.lifeSpan;
    }

    public void setLifeSpan(double lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public double getLivedFor() {
        return this.livedFor;
    }

    public void setLivedFor(double livedFor) {
        this.livedFor = livedFor;
    }

}
