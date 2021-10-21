package Engine;

public class GameVariables {

    private int ticksPerSecond;
    private int windowWidth;
    private int windowHeight;

    public GameVariables() {
        ticksPerSecond = 60;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getTicksPerSecond() {
        return this.ticksPerSecond;
    }

    public void setTicksPerSecond(int ticksPerSecond) {
        this.ticksPerSecond = ticksPerSecond;
    }

}
