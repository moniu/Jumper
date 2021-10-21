package Engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
public class RelativeGraphics {
    private Graphics graphics;
    private Scene scene;

    public RelativeGraphics(Graphics graphics, Scene scene) {
        this.graphics = graphics;
        this.scene = scene;
    }
    public Color getColor() {
        return graphics.getColor();
    }
    public void setColor(Color c) {
        graphics.setColor(c);
        
    }
    public Font getFont() {
        return graphics.getFont();
    }
    public void setFont(Font font) {
        graphics.setFont(font);
        
    }
    public void drawLine(double x1, double y1, double x2, double y2) {
        int ix1, iy1, ix2, iy2;
        ix1 = translateX(x1);
        iy1 = translateY(y1);
        ix2 = translateX(x2);
        iy2 = translateY(y2);
        graphics.drawLine(ix1, iy1, ix2, iy2);
    }
    public void fillRect(double x, double y, double width, double height) {
        int ix, iy, iwidth, iheight;
        ix = translateX(x);
        iy = translateY(y);
        iwidth = translateSize(width);
        iheight = translateSize(height);

        graphics.fillRect(ix, iy, iwidth, iheight);
        
    }
    public void drawRoundRect(double x, double y, double width, double height, double arcWidth, double arcHeight) {
        int ix, iy, iWidth, iHeight, iArcWidth, iArcHeight;
        ix = translateX(x);
        iy = translateY(y);
        iWidth = translateSize(width);
        iHeight = translateSize(height);
        iArcWidth = translateSize(arcWidth);
        iArcHeight = translateSize(arcHeight);

        graphics.drawRoundRect(ix, iy, iWidth, iHeight, iArcWidth, iArcHeight);
        
    }
    public void fillRoundRect(double x, double y, double width, double height, double arcWidth, double arcHeight) {
        int ix, iy, iWidth, iHeight, iArcWidth, iArcHeight;
        ix = translateX(x);
        iy = translateY(y);
        iWidth = translateSize(width);
        iHeight = translateSize(height);
        iArcWidth = translateSize(arcWidth);
        iArcHeight = translateSize(arcHeight);

        graphics.fillRoundRect(ix, iy, iWidth, iHeight, iArcWidth, iArcHeight);
        
    }
    public void drawOval(double x, double y, double width, double height) {
        int ix, iy, iWidth, iHeight;
        ix = translateX(x);
        iy = translateY(y);
        iWidth = translateSize(width);
        iHeight = translateSize(height);

        graphics.drawOval(ix, iy, iWidth, iHeight);
        
    }
    public void fillOval(double x, double y, double width, double height) {
        int ix, iy, iWidth, iHeight;
        ix = translateX(x);
        iy = translateY(y);
        iWidth = translateSize(width);
        iHeight = translateSize(height);

        graphics.fillOval(ix, iy, iWidth, iHeight);
        
    }
    public void drawArc(double x, double y, double width, double height, int startAngle, int arcAngle) {
        int ix, iy, iWidth, iHeight;
        ix = translateX(x);
        iy = translateY(y);
        iWidth = translateSize(width);
        iHeight = translateSize(height);


        graphics.drawArc(ix, iy, iWidth, iHeight, startAngle, arcAngle);
        
    }
    public void fillArc(double x, double y, double width, double height, int startAngle, int arcAngle) {
        int ix, iy, iWidth, iHeight;
        ix = translateX(x);
        iy = translateY(y);
        iWidth = translateSize(width);
        iHeight = translateSize(height);

        graphics.fillArc(ix, iy, iWidth, iHeight, startAngle, arcAngle);
        
    }
    public void drawPolyline(double[] xPoints, double[] yPoints, int nPoints) {
        int[] ixPoints, iyPoints;
        ixPoints = new int[nPoints];
        iyPoints = new int[nPoints];

        int ix, iy;
        for (int i=0;i<nPoints;i++) {
            ix = (int) xPoints[i];
            iy = (int) yPoints[i];
            ixPoints[i] = translateX(ix);
            iyPoints[i] = translateY(iy);
        }
        graphics.drawPolyline(ixPoints, iyPoints, nPoints);
        
    }
    public void drawPolygon(double[] xPoints, double[] yPoints, int nPoints) {
        int[] ixPoints, iyPoints;
        ixPoints = new int[nPoints];
        iyPoints = new int[nPoints];

        int ix, iy;
        for (int i=0;i<nPoints;i++) {
            ix = (int) xPoints[i];
            iy = (int) yPoints[i];
            ixPoints[i] = translateX(ix);
            iyPoints[i] = translateY(iy);
        }
        graphics.drawPolygon(ixPoints, iyPoints, nPoints);
        
    }
    public void fillPolygon(double[] xPoints, double[] yPoints, int nPoints) {
        int[] ixPoints, iyPoints;
        ixPoints = new int[nPoints];
        iyPoints = new int[nPoints];

        int ix, iy;
        for (int i=0;i<nPoints;i++) {
            ix = (int) xPoints[i];
            iy = (int) yPoints[i];
            ixPoints[i] = translateX(ix);
            iyPoints[i] = translateY(iy);
        }
        graphics.fillPolygon(ixPoints, iyPoints, nPoints);
        
    }
    public void drawString(String str, double x, double y) {
        int ix, iy;
        ix = translateX(x);
        iy = translateY(y);

        graphics.drawString(str, ix, iy);
        
    }
    public boolean drawImage(Image img, double x, double y, ImageObserver observer) {
        int ix, iy;
        ix = translateX(x);
        iy = translateY(y);
        return graphics.drawImage(img, ix, iy, observer);
    }
    public boolean drawImage(Image img, double x, double y, double width, double height, ImageObserver observer) {
        int ix, iy, iWidth, iHeight;
        ix = translateX(x);
        iy = translateY(y);
        iWidth = translateSize(width);
        iHeight = translateSize(height);
        return graphics.drawImage(img, ix, iy, iWidth, iHeight, observer);
    }

    private int translateX(double x){
        Camera camera = scene.getCamera();
        double relativeX = x - camera.getX();
        relativeX += scene.game.WIDTH / 2 / camera.getZoom();
        return (int) relativeX;
    }
    private int translateY(double y){
        Camera camera = scene.getCamera();
        double relativeY = y - camera.getY();
        relativeY += scene.game.HEIGHT / 2 / camera.getZoom();
        return (int) relativeY;
    }
    private int translateSize(double a) {
        Camera camera = scene.getCamera();
        int newA = (int) (a/camera.getZoom());
        return newA;
    }

    public Graphics getGraphics() {
        return this.graphics;
    }


}
