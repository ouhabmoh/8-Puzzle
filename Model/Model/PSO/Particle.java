package Model.Model.PSO;

import Model.Model.Actions.Action;
import Model.Model.Actions.ActionVide;
import Model.Model.Taquin.Taquin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Particle {
    private double velocity;
    private long position;
    private double fitness;
    private double bestPosition;
    private double bestFitness;
    private List<Action> actions = new ArrayList<>();
    private Taquin etat;


    public Particle(int velocity, int position, List<Action> solution, Taquin etat) {
        this.velocity = velocity;
        this.position = position;
        this.actions = solution;
        this.etat = etat;
    }

    public Particle() {

    }

    public Particle(Taquin taquin){
        this.etat = taquin;
    }


    public void updateVelocity(double w, double c1, double c2, long globalPosition){
        Random rn = new Random();
        double r1 = rn.nextDouble();
        double r2 = rn.nextDouble();
        velocity = w * velocity + c1 * r1 * (bestPosition - position) +
                c2 * r2 * (globalPosition - position);
    }

    public void updatePosition(){
        position += velocity;
        actions = PositionBinary.getActions(position);

    }

    public void fixPosition(Taquin etatInitial){
        InitParticles.fixParticle(this, etatInitial);
        position = Math.abs(PositionBinary.getPosition(actions));

    }

    public void updateFitness(){
        FitnessFunction.evaluate(this);
    }

    public void updateBestPosition(){
        if(fitness < bestFitness){
            bestFitness = fitness;
            bestPosition = position;
        }
    }
    public boolean ajouterAction(Action action){
        action.action(etat);

        return actions.add(action);
    }


    public boolean isActionValide(Action action){


        return action.isActionValide(etat) && !action.eq(getLastAction());
    }

    public Action getAction(int index){
        return actions.get(index);
    }

    public Taquin appliquerActions(){
        for(Action action:actions)
            action.action(etat);
        return etat;
    }

    public List<Action> getActions() {
        return actions;
    }

    public Action getLastAction(){
        if(actions.size() == 0)
            return new ActionVide();

        return actions.get(actions.size()-1);
    }



    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(double bestPosition) {
        this.bestPosition = bestPosition;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }

    public List<Action> getSolution() {
        return actions;
    }

    public void setSolution(List<Action> solution) {
        this.actions = solution;
    }

    public Taquin getEtat() {
        return etat;
    }

    public void setEtat(Taquin etat) {
        this.etat = etat;
    }
}
