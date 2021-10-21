package Jumper.Menu;

import Engine.Game;
import Engine.KeyHandler;
import Engine.Scene;
import Engine.SquareGraphicObject;

import java.awt.Color;
import java.awt.event.*;
import Jumper.Jumper;

public class GameWon extends Scene{
    
    private Title title;
    private Option option;
    private SquareGraphicObject background;

    public GameWon(Game game) {
        super(game);

        background = new SquareGraphicObject(this);
        background.setColor(Color.DARK_GRAY);
        background.setSizeX(game.WIDTH);
        background.setSizeY(game.WIDTH);
        addChild(background);
        registerGraphicObject(background);

        title = new Title(this,"Game Won", "Good job!");
        title.setLocalY(-300);
        addChild(title);

        option = new Option(this, "Main Menu");
        option.setLocalY(0);
        option.setSelected(true);
        addChild(option);
        
    }

    public void customTick(double deltaTime) {
        KeyHandler keyHandler = getGame().getKeyHandler();
        if (keyHandler.getKeyPressedOnce(KeyEvent.VK_ENTER)) {
                ((Jumper)getGame()).changeToMenu();
        }
    }
    
}
