package Jumper.Stages;

import Engine.Game;
import Engine.Scene;

public class Stage extends Scene{

    public Stage(Game game) {
        super(game);
        setup();
    }

    public void setup() {
        removeAllChildren();
        graphicObjects.clear();
        physicalObjects.clear();
        
        camera.setX(0);
        camera.setY(0);
    }
}
