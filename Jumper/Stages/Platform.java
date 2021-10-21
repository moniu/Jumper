package Jumper.Stages;

import Engine.GameObject;
import Engine.ImageObject;
import Engine.PhysicalObject;
import Engine.RectangleHitbox;
import Engine.Scene;


public class Platform extends GameObject{
    private ImageObject grass;
    private ImageObject dirt;
    private RectangleHitbox hitbox;
    private PhysicalObject physicalObject;
    public Platform(Scene scene, double posX, double posY, double sizeX, double sizeY) {
        super(scene);

        this.setLocalX(posX);
        this.setLocalY(posY);
        
        grass = new ImageObject(scene, "Jumper/Images/grass.png");
        grass.setSizeX(sizeX+20);
        grass.setSizeY(sizeY*0.9);
        grass.setLocalY(sizeY*-0.05);
        grass.setLayer(31);
        grass.setRelative(true);
        
        dirt = new ImageObject(scene, "Jumper/Images/dirt.png");
        dirt.setSizeX(sizeX);
        dirt.setSizeY(sizeY*0.9);
        dirt.setLocalY(sizeY*0.05);
        dirt.setLayer(30);
        dirt.setRelative(true);
        
        hitbox = new RectangleHitbox(scene, sizeX, sizeY);
        
        physicalObject = new PhysicalObject(scene);
        physicalObject.setFrozen(true);
        physicalObject.setHitbox(hitbox);
        
        addChild(grass);
        addChild(dirt);
        addChild(hitbox);
        addChild(physicalObject);
        scene.registerGraphicObject(grass);
        scene.registerGraphicObject(dirt);
        scene.registerPhysicalObject(physicalObject);

    }
    
}
