package Jumper.Stages;

import Engine.GameObject;
import Engine.RectangleHitbox;
import Engine.Scene;

public class KillTrigger extends GameObject{

    private RectangleHitbox hitbox;
    private Player player;
    private double sizeX, sizeY;

    public KillTrigger(Scene scene, Player player, double sizeX, double sizeY) {
        super(scene);

        this.player = player;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        
        hitbox = new RectangleHitbox(scene, sizeX, sizeY);
        addChild(hitbox);
    }

    public void customTick(double deltaTime) {
        if(hitbox.checkCollision(player.getHitbox())) {
            player.kill();
        }
    }


    public RectangleHitbox getHitbox() {
        return this.hitbox;
    }

    public Player getPlayer() {
        return this.player;
    }

    public double getSizeX() {
        return this.sizeX;
    }

    public double getSizeY() {
        return this.sizeY;
    }

}
