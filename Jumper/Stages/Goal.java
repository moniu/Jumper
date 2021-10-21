package Jumper.Stages;


import Engine.GameObject;
import Engine.ImageObject;
import Engine.RectangleHitbox;
import Engine.Scene;
import Jumper.Menu.GameWon;

public class Goal extends GameObject{

    private ImageObject graphicObject;
    private RectangleHitbox hitbox;
    private Player player;

    public Goal(Scene scene, Player player, double posX, double posY, double sizeX, double sizeY) {
        super(scene);
        this.player = player;
        setLocalX(posX);
        setLocalY(posY);

        graphicObject = new ImageObject(scene, "Jumper/Images/goal.png");
        graphicObject.setSizeX(sizeX*1.5);
        graphicObject.setSizeY(sizeY*1.5);
        graphicObject.setLayer(50);
        graphicObject.setRelative(true);

        addChild(graphicObject);
        scene.registerGraphicObject(graphicObject);
        hitbox = new RectangleHitbox(scene, sizeX, sizeY);
        addChild(hitbox);
    }

    public void customTick(double deltaTime) {
        if(hitbox.checkCollision(player.getHitbox())) {
            getGame().setScene(new GameWon(getGame()));
        }
    }


    public RectangleHitbox getHitbox() {
        return this.hitbox;
    }

    public Player getPlayer() {
        return this.player;
    }

}
