package Jumper.Menu;

import java.awt.Color;

import Engine.GameObject;
import Engine.Scene;
import Engine.Text;

public class Title extends GameObject{
    private Text titleText;
    private Text titleShadow;
    private Text subTitleText;
    private Text subTitleShadow;

    private boolean hasSubTitle;


    public Title(Scene scene, String mainTitle, String secondTitle) {
        super(scene);

        hasSubTitle = true;
        
        titleText = new Text(scene, mainTitle, 100, Color.WHITE);
        titleShadow = new Text(scene, mainTitle, 100, Color.BLACK);
        subTitleText = new Text(scene, secondTitle, 30, Color.GRAY);
        subTitleShadow = new Text(scene, secondTitle, 30, Color.BLACK);

        subTitleText.setLocalY(60);
        subTitleText.setLocalX(40);
        subTitleShadow.setLocalY(63);
        subTitleShadow.setLocalX(43);
        titleShadow.setLocalX(5);
        titleShadow.setLocalY(5);

        titleShadow.setLayer(9);
        titleText.setLayer(10);
        subTitleShadow.setLayer(11);
        subTitleText.setLayer(12);

        addChild(titleText);
        addChild(titleShadow);
        addChild(subTitleText);
        addChild(subTitleShadow);

        scene.registerGraphicObject(titleText);
        scene.registerGraphicObject(titleShadow);
        scene.registerGraphicObject(subTitleText);
        scene.registerGraphicObject(subTitleShadow);
    }
    public Title(Scene scene, String mainTitle) {
        super(scene);

        hasSubTitle = false;
        
        titleText = new Text(scene, mainTitle, 100, Color.WHITE);
        titleShadow = new Text(scene, mainTitle, 100, Color.BLACK);

        titleShadow.setLocalX(5);
        titleShadow.setLocalY(5);

        titleShadow.setLayer(9);
        titleText.setLayer(10);

        addChild(titleText);
        addChild(titleShadow);

        scene.registerGraphicObject(titleText);
        scene.registerGraphicObject(titleShadow);
    }

    public boolean hasSubTitle() {
        return hasSubTitle;
    }
    
}
