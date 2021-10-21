package Engine;

import java.awt.Color;
import java.awt.event.*;

public class Player extends GameObject{
    private PhysicalObject physicalObject;
    private SquareGraphicObject graphicObject;
    private Hitbox hitbox;

    private RectangleHitbox leftHitbox;
    private RectangleHitbox rightHitbox;
    private RectangleHitbox bottomHitbox;
    private RectangleHitbox topHitbox;
    
    public Player(Scene scene) {
        super(scene);

        double playerWidth = 30;
        double playerHeight = 100;

        leftHitbox = new RectangleHitbox(scene, 1, playerHeight-2);
        leftHitbox.setLocalX(-playerWidth/2-2);
        addChild(leftHitbox);
        rightHitbox = new RectangleHitbox(scene, 1, playerHeight-2);
        rightHitbox.setLocalX(playerWidth/2+2);
        addChild(rightHitbox);
        topHitbox = new RectangleHitbox(scene, playerWidth-2, 1);
        topHitbox.setLocalY(-playerHeight/2-2);
        addChild(topHitbox);
        bottomHitbox = new RectangleHitbox(scene, playerWidth-2, 2);
        bottomHitbox.setLocalY(playerHeight/2+2);
        addChild(bottomHitbox);


        this.graphicObject = new SquareGraphicObject(scene);
        this.graphicObject.setSizeX(playerWidth);
        this.graphicObject.setSizeY(playerHeight);
        this.graphicObject.setColor(Color.LIGHT_GRAY);
        this.graphicObject.setLayer(10);
        this.graphicObject.setRelative(true);
        
        this.physicalObject = new PhysicalObject(scene);
        this.hitbox = new RectangleHitbox(scene, playerWidth, playerHeight);
        this.physicalObject.setHitbox(hitbox);
        scene.registerGraphicObject(graphicObject);
        scene.registerPhysicalObject(physicalObject);

        addChild(graphicObject);
        addChild(physicalObject);

        physicalObject.setHitbox(hitbox);
    }


    @Override
    public void customTick(double deltaTime) {

        boolean topCollides, bottomCollides, leftCollides, rightCollides;
        topCollides = false;
        bottomCollides = false;
        leftCollides = false;
        rightCollides = false;
        for (PhysicalObject po : scene.getPhysicalObjects()) {
            if (po == this.physicalObject) {
                continue;
            }
            Hitbox h = po.getHitbox();
            if (leftHitbox.checkCollision(h)) {
                leftCollides = true;
            }
            if (rightHitbox.checkCollision(h)) {
                rightCollides = true;
            }
            if (topHitbox.checkCollision(h)) {
                topCollides = true;
            }
            if (bottomHitbox.checkCollision(h)) {
                bottomCollides = true;
            }
        }

        if(game.keyHandler.getKeyPressed(KeyEvent.VK_LEFT) && !leftCollides) {
            this.physicalObject.setSpeedX(Math.min(-600, this.physicalObject.getSpeedX() ) );
        }
        if(game.keyHandler.getKeyPressed(KeyEvent.VK_RIGHT) && !rightCollides) {
            this.physicalObject.setSpeedX(Math.max(600,  this.physicalObject.getSpeedX() ) );
        }
        if(game.keyHandler.getKeyPressed(KeyEvent.VK_UP) && !topCollides && bottomCollides) {
            this.physicalObject.setSpeedY(-1000);
        }

        
        
        Camera camera = getScene().getCamera();
        camera.setX(this.getGlobalX());
        camera.setY(this.getGlobalY());
    }
    
}
