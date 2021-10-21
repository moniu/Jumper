package Jumper.Menu;

import Engine.Game;
import Engine.KeyHandler;
import Engine.Scene;
import Engine.SquareGraphicObject;

import java.awt.Color;
import java.awt.event.*;
import Jumper.Jumper;

public class PauseMenu extends Scene{

    private Scene returnScene;
    private int selectedNr;
    
    private Title title;
    private Option options[];
    private SquareGraphicObject background;

    public PauseMenu(Game game, Scene returnScene) {
        super(game);

        this.returnScene = returnScene;

        background = new SquareGraphicObject(this);
        background.setColor(Color.DARK_GRAY);
        background.setSizeX(game.WIDTH);
        background.setSizeY(game.WIDTH);
        addChild(background);
        registerGraphicObject(background);

        title = new Title(this,"Paused", "Need a break?");
        title.setLocalY(-300);
        addChild(title);

        options = new Option[2];
        options[0] = new Option(this, "Return");
        options[1] = new Option(this, "Main menu");
        options[0].setLocalY(0);
        options[1].setLocalY(150);
        addChild(options[0]);
        addChild(options[1]);
        
    }

    public void customTick(double deltaTime) {
        KeyHandler keyHandler = getGame().getKeyHandler();
        if(keyHandler.getKeyPressedOnce(KeyEvent.VK_DOWN)) {
            selectedNr += 1;
            if (selectedNr > 1) {
                selectedNr = 0;
            }
        }
        if(keyHandler.getKeyPressedOnce(KeyEvent.VK_UP)) {
            selectedNr -= 1;
            if (selectedNr < 0) {
                selectedNr = 1;
            }  
        }
        if (selectedNr == 0) {
            options[0].setSelected(true);
            options[1].setSelected(false);
        }
        if (selectedNr == 1) {
            options[0].setSelected(false);
            options[1].setSelected(true);
        }
        if (keyHandler.getKeyPressedOnce(KeyEvent.VK_ENTER)) {
            if (selectedNr == 0) {
                ((Jumper)getGame()).setScene(returnScene);
            }
            if (selectedNr == 1) {
                ((Jumper)getGame()).changeToMenu();
            }
        }
    }
    
}
