package Engine;

public class TickThread implements Runnable{
    private Game game;
    public TickThread(Game game) {
        this.game = game;
    }
    @Override
    public synchronized void run() {
        long now;
        long lastTime = System.nanoTime();
        double deltaTime = 0;
        double secondCounter = 0;
        int frameCounter = 0;
        while(true) {
            now = System.nanoTime();
            deltaTime = now - lastTime;
            secondCounter += deltaTime;
            lastTime = now;
            frameCounter++;
            game.scene.tick(deltaTime);
            if (secondCounter >= 1_000_000_000) {
                game.lastFPS = frameCounter;
                secondCounter = 0;
                frameCounter = 0;
            }
        }
    }
    
}
