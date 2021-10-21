package Jumper.Stages;

import java.util.HashMap;
import java.util.Random;
import java.awt.event.*;

import Engine.*;
import Jumper.Menu.GameOver;

public class Player extends GameObject{
    private PhysicalObject physicalObject;
    private AnimatedObject graphicObject;
    private Hitbox hitbox;

    private boolean facingRight;

    private RectangleHitbox leftHitbox;
    private RectangleHitbox rightHitbox;
    private RectangleHitbox bottomHitbox;
    private RectangleHitbox topHitbox;
    private double footstepTimeout;

    private Random random;
    
    public Player(Scene scene) {
        super(scene);


        random = new Random();
        double playerWidth = 50;
        double playerHeight = 50;


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


        HashMap<String, Animation> animations = new HashMap<>();
        String[] filenames;
        Animation animation;

        SoundManager soundManager = getGame().getSoundManager();
        soundManager.preloadSound("Jumper/Sounds/step0.wav");
        soundManager.preloadSound("Jumper/Sounds/step1.wav");
        soundManager.preloadSound("Jumper/Sounds/step2.wav");
        soundManager.preloadSound("Jumper/Sounds/jump0.wav");

        filenames = new String[]{
            "Jumper/Images/DinoIdleLeft0.png",
            "Jumper/Images/DinoIdleLeft1.png",
            "Jumper/Images/DinoIdleLeft2.png",
            "Jumper/Images/DinoIdleLeft3.png",
        };
        animation = new Animation(scene, 0.1, filenames);
        animations.put("IdleLeft", animation);
        
        filenames = new String[]{
            "Jumper/Images/DinoIdleRight0.png",
            "Jumper/Images/DinoIdleRight1.png",
            "Jumper/Images/DinoIdleRight2.png",
            "Jumper/Images/DinoIdleRight3.png",
        };
        animation = new Animation(scene, 0.1, filenames);
        animations.put("IdleRight", animation);

        filenames = new String[]{
            "Jumper/Images/DinoWalkLeft0.png",
            "Jumper/Images/DinoWalkLeft1.png",
            "Jumper/Images/DinoWalkLeft2.png",
            "Jumper/Images/DinoWalkLeft3.png",
            "Jumper/Images/DinoWalkLeft4.png",
            "Jumper/Images/DinoWalkLeft5.png",
        };
        animation = new Animation(scene, 0.1, filenames);
        animations.put("WalkLeft", animation);

        filenames = new String[]{
            "Jumper/Images/DinoWalkRight0.png",
            "Jumper/Images/DinoWalkRight1.png",
            "Jumper/Images/DinoWalkRight2.png",
            "Jumper/Images/DinoWalkRight3.png",
            "Jumper/Images/DinoWalkRight4.png",
            "Jumper/Images/DinoWalkRight5.png",
        };
        animation = new Animation(scene, 0.1, filenames);
        animations.put("WalkRight", animation);

        this.graphicObject = new AnimatedObject(scene, animations);
        this.graphicObject.changeAnimation("IdleRight");
        this.graphicObject.setSizeX(playerWidth*1.5);
        this.graphicObject.setSizeY(playerHeight*1.5);
        this.graphicObject.setLayer(50);
        this.graphicObject.setRelative(true);
        
        this.physicalObject = new PhysicalObject(scene);
        this.hitbox = new RectangleHitbox(scene, playerWidth, playerHeight);
        this.physicalObject.setHitbox(hitbox);
        physicalObject.setHitbox(hitbox);
        physicalObject.setGravityY(80);
        physicalObject.setWeight(20);


        getScene().registerGraphicObject(graphicObject);
        getScene().registerPhysicalObject(physicalObject);
        addChild(graphicObject);
        addChild(physicalObject);

    }


    @Override
    public void customTick(double deltaTime) {

        boolean topCollides, bottomCollides, leftCollides, rightCollides;
        topCollides = false;
        bottomCollides = false;
        leftCollides = false;
        rightCollides = false;
        for (PhysicalObject po : getScene().getPhysicalObjects()) {
            if (po == this.physicalObject || !po.isColliding()) {
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

        SoundManager soundManager = getGame().getSoundManager();
        KeyHandler keyHandler = getGame().getKeyHandler();
        if(keyHandler.getKeyPressed(KeyEvent.VK_LEFT) && !leftCollides) {
            this.physicalObject.setSpeedX(Math.min(-600, this.physicalObject.getSpeedX() ) );
            this.facingRight = false;
            this.graphicObject.changeAnimation("WalkLeft");
            if (bottomCollides) {
                playFootstep(deltaTime);
            }
        }
        if(keyHandler.getKeyPressed(KeyEvent.VK_RIGHT) && !rightCollides) {
            this.physicalObject.setSpeedX(Math.max(600,  this.physicalObject.getSpeedX() ) );
            this.facingRight = true;
            this.graphicObject.changeAnimation("WalkRight");
            if (bottomCollides) {
                playFootstep(deltaTime);
            }
        }
        if (!keyHandler.getKeyPressed(KeyEvent.VK_LEFT) && !keyHandler.getKeyPressed(KeyEvent.VK_RIGHT) ) {
            this.physicalObject.setSpeedX(0);
            this.footstepTimeout = 0;
            if (facingRight) {
                this.graphicObject.changeAnimation("IdleRight");
            }
            else {
                this.graphicObject.changeAnimation("IdleLeft");
            }
        }
        if(keyHandler.getKeyPressed(KeyEvent.VK_UP) && !topCollides && bottomCollides) {
            this.physicalObject.setSpeedY(-1000);
            soundManager.playSound("Jumper/Sounds/jump0.wav");
        }
        if(keyHandler.getKeyPressed(KeyEvent.VK_SPACE)) {
            kill();
        }

        
        Camera camera = getScene().getCamera();
        camera.setX(this.getGlobalX());
        camera.setY(this.getGlobalY());
    }

    public void kill() {
        getScene().unregisterGraphicObject(graphicObject);
        getScene().unregisterPhysicalObject(physicalObject);
        removeAllChildren();
        getScene().removeChild(this);
        getGame().setScene(new GameOver(getGame(), (Stage)getScene()));
    }

    public void playFootstep(double deltaTime) {
        footstepTimeout-=deltaTime;
        if (footstepTimeout < 0) {
            footstepTimeout = 300_000_000;
            SoundManager soundManager = getGame().getSoundManager();
            
            int r = random.nextInt(2);
            soundManager.playSound("Jumper/Sounds/step"+r+".wav");

        }
    }


    public PhysicalObject getPhysicalObject() {
        return this.physicalObject;
    }

    public AnimatedObject getGraphicObject() {
        return this.graphicObject;
    }

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public RectangleHitbox getLeftHitbox() {
        return this.leftHitbox;
    }

    public RectangleHitbox getRightHitbox() {
        return this.rightHitbox;
    }

    public RectangleHitbox getBottomHitbox() {
        return this.bottomHitbox;
    }

    public RectangleHitbox getTopHitbox() {
        return this.topHitbox;
    }
    
    
}
