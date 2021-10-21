package Jumper.Stages;

import Engine.Animation;
import Engine.Particle;
import Engine.PhysicalObject;
import Engine.RectangleHitbox;
import Engine.Scene;

public class FireParticle extends Particle{

    protected PhysicalObject physicalObject;
    protected Animation graphicObject;
    protected RectangleHitbox hitbox;
    protected double shakingAngle;

    public FireParticle(Scene scene) {
        super(scene);
        lifeSpan = 1;

        String[] frames = {
            "Jumper/Images/fire0.png",
            "Jumper/Images/fire1.png",
            "Jumper/Images/fire2.png",
            "Jumper/Images/fire3.png",
            "Jumper/Images/fire4.png",
        };
        graphicObject = new Animation(scene, 0.2, frames);
        graphicObject.setSizeX(40);
        graphicObject.setSizeY(40);
        graphicObject.setRelative(true);
        graphicObject.setLayer(32);
        addChild(graphicObject);
        getScene().registerGraphicObject(graphicObject);


        physicalObject = new PhysicalObject(scene);
        physicalObject.setColliding(false);
        physicalObject.setGravityY(-30);
        physicalObject.setWeight(10);
        addChild(physicalObject);

        hitbox = new RectangleHitbox(scene, 10, 10);
        addChild(hitbox);
        physicalObject.setHitbox(hitbox);

        scene.registerPhysicalObject(physicalObject);

        
    }

    @Override
    public void customTick(double deltaTime) {
        shakingAngle += deltaTime/1_000_000_00;
        shakingAngle %= 2*Math.PI;

        physicalObject.setSpeedX(10*Math.sin(shakingAngle));
    }

    @Override
    public synchronized void kill() {
        getScene().unregisterGraphicObject(graphicObject);
        getScene().unregisterPhysicalObject(physicalObject);
        removeAllChildren();
        getMaster().removeChild(this);
    }
    
}
