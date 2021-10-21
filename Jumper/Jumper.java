package Jumper;

import Engine.*;
import Jumper.Stages.*;
import Jumper.Menu.MenuScene;

public class Jumper extends Game {

    private MenuScene menuScene;
    private Stage[] stages;
    
    public Jumper(int width, int height) {
        super(width, height, "Jumper");
        menuScene = new MenuScene(this);
        stages = new Stage[2];
        stages[0] = new FirstStage(this);
        stages[1] = new SecondStage(this);
        getSoundManager().playLoop("Jumper/Sounds/When_Im_46.wav");
        setScene(menuScene);
    }



    public static void main(String[] args) {
        Jumper jumper = new Jumper(1000, 800);
        jumper.start();
    }

    public void changeToMenu() {
        setScene(menuScene);
    }
    public void changeToStage(int stageNr) {
        stages[stageNr].setup();
        setScene(stages[stageNr]);
    }

    public MenuScene getMenuScene() {
        return menuScene;
    }
    
}
