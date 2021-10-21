package Engine;

import java.awt.*;

public class Game extends Canvas{
    public int WIDTH;
    public int HEIGHT;

    Window window;
    Thread tickThread;
    Thread renderThread;
    GameVariables gameVariables;
    RenderEngine renderEngine;
    Scene scene;
    KeyHandler keyHandler;
    ResourceManager resourceManager;
    SoundManager soundManager;

    int lastFPS;

    public static void main(String[] args) {
        Game game = new Game(800, 600, "game");
        game.start();
    }

    public Game(int width, int height, String name) {
        WIDTH = width;
        HEIGHT = height;

        resourceManager = new ResourceManager();
        soundManager = new SoundManager();

        gameVariables = new GameVariables();
        gameVariables.setWindowWidth(width);
        gameVariables.setWindowHeight(height);

        this.keyHandler = new KeyHandler();
        this.addKeyListener(this.keyHandler);
        
        window = new Window(width, height, name, this);
        renderEngine = new RenderEngine(this);
        scene = new Scene(this);
        lastFPS = 0;

    }

    public synchronized void start() {
        tickThread = new Thread(new TickThread(this), "GameTickThread");
        renderThread = new Thread(new RenderThread(this), "GameRenderThread");
        tickThread.start();
        renderThread.start();
    }

    public void stop() {
        try {
            tickThread.join();
            renderThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        //stop();
        System.exit(0);
    }

    public Scene getScene() {
        return scene;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }




    public Window getWindow() {
        return this.window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Thread getTickThread() {
        return this.tickThread;
    }

    public void setTickThread(Thread tickThread) {
        this.tickThread = tickThread;
    }

    public Thread getRenderThread() {
        return this.renderThread;
    }

    public void setRenderThread(Thread renderThread) {
        this.renderThread = renderThread;
    }

    public GameVariables getGameVariables() {
        return this.gameVariables;
    }

    public void setGameVariables(GameVariables gameVariables) {
        this.gameVariables = gameVariables;
    }

    public RenderEngine getRenderEngine() {
        return this.renderEngine;
    }

    public void setRenderEngine(RenderEngine renderEngine) {
        this.renderEngine = renderEngine;
    }

    public KeyHandler getKeyHandler() {
        return this.keyHandler;
    }

    public void setKeyHandler(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }

    public int getLastFPS() {
        return this.lastFPS;
    }

    public void setLastFPS(int lastFPS) {
        this.lastFPS = lastFPS;
    }
    public ResourceManager getResourceManager() {
        return this.resourceManager;
    }
    public SoundManager getSoundManager() {
        return this.soundManager;
    }


}
