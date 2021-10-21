package Engine;

public class Camera {
    private double x;
    private double y;
    private double zoom;

    public double getX() {
        return this.x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return this.y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getZoom() {
        return this.zoom;
    }
    public void setZoom(double zoom) {
        this.zoom = zoom;
    }
    public Camera(double x, double y, double zoom) {
        this.x = x;
        this.y = y;
        this.zoom = zoom;
    }
}
