package Engine;

import java.awt.Color;

public class SquareGraphicObject extends GraphicObject{
    Color color;
    double sizeX, sizeY;
    

    public SquareGraphicObject(Scene scene) {
        super(scene);
        color = Color.BLACK;
        sizeX = 0.0;
        sizeY = 0.0;
        this.setRelative(true);
    }
    @Override
    public synchronized void render(RelativeGraphics relativeGraphics) {
        relativeGraphics.setColor(color);
        if (this.getRelative()) {
            relativeGraphics.fillRect(this.getGlobalX()-sizeX/2, this.getGlobalY()-sizeY/2, sizeX, sizeY);
        }
        else {
            relativeGraphics.getGraphics().fillRect((int)this.getGlobalX(), (int)this.getGlobalY(), (int)sizeX, (int)sizeY);
        }
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getSizeX() {
        return this.sizeX;
    }

    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }

    public double getSizeY() {
        return this.sizeY;
    }

    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    
}
