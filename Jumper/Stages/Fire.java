package Jumper.Stages;

import java.util.Iterator;

import Engine.ParticleEmmiter;
import Engine.Scene;

public class Fire extends ParticleEmmiter<FireParticle>{
    public Fire(Scene scene) {
        super(scene);
        maxParticles = 10000;
    }

    @Override
    public synchronized void customTick(double deltaTime) {
        Iterator<FireParticle> pIterator = particles.iterator();
        FireParticle p;
        while(pIterator.hasNext()) {
            p = pIterator.next();
            double livedFor = p.getLivedFor();
            double lifeSpan = p.getLifeSpan();
            double newLivedFor = livedFor+deltaTime/1_000_000_000;
            if (newLivedFor > lifeSpan) {
                p.kill();
                pIterator.remove();
                continue;
            }
            p.setLivedFor(newLivedFor);
        }

        double chance = (deltaTime/1_000_000_000) * (maxParticles-particles.size()) / maxParticles * 10;
        
        if (random.nextDouble() < chance) {
            FireParticle particle = new FireParticle(getScene());
            particles.add(particle);
            particle.setLocalX(random.nextDouble()*50-25);
            
            addChild(particle);
            
        }

    }
}
