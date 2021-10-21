package Engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Font;


public class RenderEngine {
    private BufferStrategy bufferStrategy;
    private int width;
    private int height;
    private Game game;
    public RenderEngine(Game game) {
        this.game = game;
        game.createBufferStrategy(2);

        width = game.gameVariables.getWindowWidth();
        height = game.gameVariables.getWindowHeight();
    }
    public synchronized void render() {
        bufferStrategy = game.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(game.scene.backgroundColor);
        graphics.fillRect(0, 0, width, height);
        RelativeGraphics relativeGraphics = new RelativeGraphics(graphics, game.scene);

        //Render all objects in current scene
        ArrayList<GraphicObject> graphicObjects = game.scene.getGraphicObjects();
        synchronized(graphicObjects) {
            Collections.sort(graphicObjects);
            for (GraphicObject go : graphicObjects) {
                go.render(relativeGraphics);
            }
        }

        
        Font font = new Font("Monospace", Font.PLAIN, 12);
        graphics.setFont(font);
        graphics.setColor(Color.RED);
        String fps = Integer.toString(game.lastFPS);
        graphics.drawChars(fps.toCharArray(), 0, fps.length(), 20, 20);
        graphics.dispose();
        bufferStrategy.show();
    }
}
