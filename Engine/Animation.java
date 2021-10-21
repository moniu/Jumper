package Engine;

import java.util.ArrayList;

public class Animation extends GraphicObject{

    ArrayList<ImageObject> images;
    double frameTime;
    double frameLength;
    int currentFrame;
    int frames;

    double sizeX;
    double sizeY;

    public Animation(Scene scene, double frameLength, String[] filenames) {
        super(scene);
        images = new ArrayList<>();
        frameTime = 0;
        this.frameLength = frameLength * 1_000_000_000;
        this.frames = filenames.length;

        ImageObject imageObject;
        for (String f : filenames) {
            imageObject = new ImageObject(scene, f);
            imageObject.setSizeX(sizeX);
            imageObject.setSizeY(sizeY);
            imageObject.setLayer(layer);
            imageObject.setRelative(relative);


            images.add(imageObject);
            addChild(imageObject);
        }
    }

    @Override
    public synchronized void render(RelativeGraphics relativeGraphics) {
        ImageObject imageObject = images.get(currentFrame);
        imageObject.render(relativeGraphics);
        
    }

    @Override
    public synchronized void customTick(double deltaTime) {
        frameTime+=deltaTime;
        while (frameTime > frameLength) {
            currentFrame++;
            if (currentFrame >= frames) {
                currentFrame = 0;
            }
            frameTime-=frameLength;
        }
    }



    public double getFrameLength() {
        return this.frameLength;
    }

    public void setFrameLength(double frameLength) {
        this.frameLength = frameLength;
    }

    public int getCurrentFrame() {
        return this.currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public double getSizeX() {
        return this.sizeX;
    }

    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
        for (ImageObject io : images) {
            io.setSizeX(sizeX);
        }
    }

    public double getSizeY() {
        return this.sizeY;
    }

    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
        for (ImageObject io : images) {
            io.setSizeY(sizeY);
        }
    }

    public void setRelative(boolean relative) {
        this.relative = relative;
        for (ImageObject io : images) {
            io.setRelative(relative);
        }
    }


    
}
