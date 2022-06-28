package Model.Model.PSO;

import Model.Model.Taquin.Taquin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Swarm {
    private List<Particle> particles;
    private long bestPosition;
    private double bestFitness = 1000000;

    public Swarm(Taquin etatInitial, int nbParticles, double maxVelocity, int nbAction){
        particles = new ArrayList<>(nbParticles);
        for(int i = 0; i < nbParticles; i++){
            Random random = new Random();
            double v = random.nextDouble()*maxVelocity;
            Particle particle = InitParticles.initParticle(etatInitial, nbAction, v);
            particles.add(particle);
        }
    }


    public void updateBestPosition(){
        for(Particle particle:particles){
            if(bestFitness > particle.getFitness()){
                bestFitness = particle.getFitness();
                bestPosition = particle.getPosition();
            }
        }
    }

    public void updateVelocity(double w, double c1, double c2){
        for(Particle particle:particles){
            particle.updateVelocity(w, c1, c2, bestPosition);
        }
    }

    public void updatePosition(){
        for(Particle particle:particles){
            particle.updatePosition();
        }
    }

    public void fixPosition(Taquin etatInitial){
        for(Particle particle:particles){
            particle.fixPosition(etatInitial);
        }
    }

    public void updateFitness(){
        for(Particle particle:particles){
            particle.updateFitness();
        }
    }

    public void updateLocalPosition(){
        for(Particle particle:particles){
            particle.updateBestPosition();
        }
    }


    public List<Particle> getParticles() {
        return particles;
    }

    public void setParticles(List<Particle> particles) {
        this.particles = particles;
    }

    public long getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(long bestPosition) {
        this.bestPosition = bestPosition;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }
}
