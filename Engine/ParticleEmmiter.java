package Engine;

import java.util.ArrayList;
import java.util.Random;

public abstract class ParticleEmmiter<ParticleType extends Particle> extends GameObject{
    protected ArrayList<ParticleType> particles;
    protected int maxParticles;
    protected Random random;
    public ParticleEmmiter(Scene scene) {
        super(scene);
        random = new Random();
        particles = new ArrayList<ParticleType>();
    }

    public ArrayList<ParticleType> getParticles() {
        return this.particles;
    }

    public void setParticles(ArrayList<ParticleType> particles) {
        this.particles = particles;
    }

    // @Override
    // public void customTick(double deltaTime) {
    //     Iterator<ParticleType> pIterator = particles.iterator();
    //     ParticleType p;
    //     while(pIterator.hasNext()) {
    //         p = pIterator.next();
    //         double livedFor = p.getLivedFor();
    //         double lifeSpan = p.getLifeSpan();
    //         double newLivedFor = livedFor+deltaTime/1_000_000_000;
    //         if (newLivedFor > lifeSpan) {
    //             p.kill();
    //             pIterator.remove();
    //             continue;
    //         }
    //         p.setLivedFor(newLivedFor);
    //     }

    //     double chance = deltaTime/1_000_000_000 * (maxParticles-particles.size()) / maxParticles;

        
    //     if (random.nextDouble() < chance) {
    //         ParticleType particle = new ParticleType(getScene());
    //         particles.add(particle);
    //         addChild(particle);
            
    //     }

    // }


    

}
