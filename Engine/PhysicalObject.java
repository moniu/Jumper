package Engine;

public class PhysicalObject extends GameObject {
    private double weight;
    private double speedX, speedY;
    private double gravityX, gravityY;
    private boolean frozen;
    private boolean colliding;

    private Hitbox hitbox;

    public PhysicalObject(Scene scene) {
        super(scene);
        
        weight = 1;
        gravityX = 0;
        gravityY = 0;
        speedX = 0;
        speedY = 0;

        frozen = false;
        colliding = true;
        
    }
    public void collideWithObject(PhysicalObject other) {
        //double distance;
        //double collisionNormalX, collisionNormalY;
        //GameObject m = (GameObject) master;

        //distance = Math.sqrt(Math.pow(this.getGlobalX() - other.getGlobalX(), 2) + Math.pow(this.getGlobalY() - other.getGlobalY(), 2));
        //collisionNormalX = (this.getGlobalX() - other.getGlobalX()) / distance;
        //collisionNormalY = (this.getGlobalY() - other.getGlobalY()) / distance;

        if (other.getColliding()) {
            this.speedX = 0;
            this.speedY = 0;
        }
        //m.setLocalX(m.getLocalX() + collisionNormalX);
        //m.setLocalY(m.getLocalY() + collisionNormalY);

    }

    public void customTick(double deltaTime) {

        // @TODO dodać algorytm np AABB Minkowskiego
        if (frozen) {
            this.speedX = 0;
            this.speedY = 0;
            return;
        }

        deltaTime/=1000000000;

        GameObject m = (GameObject) master;
        m.setLocalX(m.getLocalX() + this.speedX * deltaTime);
        m.setLocalY(m.getLocalY() + this.speedY * deltaTime);

        this.speedX += (this.gravityX * this.weight * deltaTime);
        this.speedY += (this.gravityY * this.weight * deltaTime);

        for (PhysicalObject o : this.game.getScene().getPhysicalObjects()) {
            if (this.hitbox.checkCollision(o.getHitbox())) {
                this.collideWithObject(o);
            }
        }

    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public double getSpeedX() {
        return this.speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return this.speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public Hitbox getHitbox() {
        return this.hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
        hitbox.setPhysicalObject(this);
        addChild(hitbox);
    }
    
    public boolean getFrozen() {
        return frozen;
    }
    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isColliding() {
        return this.colliding;
    }

    public boolean getColliding() {
        return this.colliding;
    }

    public void setColliding(boolean colliding) {
        this.colliding = colliding;
    }


    public double getGravityX() {
        return this.gravityX;
    }

    public void setGravityX(double gravityX) {
        this.gravityX = gravityX;
    }

    public double getGravityY() {
        return this.gravityY;
    }

    public void setGravityY(double gravityY) {
        this.gravityY = gravityY;
    }

    public boolean isFrozen() {
        return this.frozen;
    }



}
