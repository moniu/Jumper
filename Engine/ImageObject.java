package Engine;

import java.awt.Image;

public class ImageObject extends GraphicObject{
    private Image image;
    private double sizeX;
    private double sizeY;
    
    public ImageObject(Scene scene, String imageName) {
        super(scene);
        image = getGame().getResourceManager().loadImage(imageName);
    }

    @Override
    public void render(RelativeGraphics relativeGraphics) {
        if (this.getRelative()) {
            relativeGraphics.drawImage(image, this.getGlobalX()-sizeX/2, this.getGlobalY()-sizeY/2, sizeX, sizeY, null);
        }
        else {
            relativeGraphics.getGraphics().drawImage(image, (int)(this.getGlobalX()), (int)(this.getGlobalY()), (int)sizeX, (int)sizeY, null);
        }
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
