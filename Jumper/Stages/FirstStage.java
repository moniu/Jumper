package Jumper.Stages;

import java.awt.Color;
import java.awt.event.*;

import Jumper.Menu.*;
import Engine.Game;
import Engine.KeyHandler;


public class FirstStage extends Stage{
    private Player player;
    public FirstStage(Game game) {
        super(game);
        backgroundColor = Color.BLUE;
    }

    @Override
    public void setup() {
        removeAllChildren();
        graphicObjects.clear();
        physicalObjects.clear();
        camera.setX(0);
        camera.setY(0);

        player = new Player(this);
        addChild(player);

        Platform platform = new Platform(this, 0, 150, 5000, 50);
        addChild(platform);
        
        platform = new Platform(this, 200, 50, 50, 50);
        addChild(platform);
        Fire fire = new Fire(this);
        addChild(fire);
        fire.setLocalX(100);
        fire.setLocalY(100);

        fire = new Fire(this);
        addChild(fire);
        fire.setLocalX(200);
        fire.setLocalY(100);
    }

    public void customTick(double deltaTime) {
        KeyHandler keyHandler = getGame().getKeyHandler();
        if (keyHandler.getKeyPressed(KeyEvent.VK_ESCAPE)) {
            getGame().setScene(new PauseMenu(getGame(), this));
        }
    }
    
}
