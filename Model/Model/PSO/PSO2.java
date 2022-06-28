package Model.Model.PSO;

import Model.Model.Actions.Action;
import Model.Model.Taquin.Taquin;

import java.util.Collections;
import java.util.List;

public class PSO2 {
    private PSOSettings psoSettings;
    private Swarm swarm;

    private Taquin etatInitial;

    public PSO2(Taquin etatInitial, PSOSettings psoSettings){
        this.psoSettings = psoSettings;
        this.etatInitial = etatInitial;
        this.swarm = new Swarm(etatInitial, psoSettings.getNbPopulation(), psoSettings.getMaxVelocity(), psoSettings.getNbAction());

    }

    public List<Action> run(){
        int i = 0;
        int maxIteration = psoSettings.getMaxIterations();
        while(i < maxIteration && !goalReached()){
            System.out.println("iteration "+i);
            System.out.println("gbest "+swarm.getBestPosition());
            System.out.println("fbest "+swarm.getBestFitness());
            System.out.println();
            updateGlobalBest();
            updateVelocity();
            updatePosition();
            fixPosition();
            updateFitness();
            updateBestLocalPosition();
            i++;
        }
        System.out.println(swarm.getBestPosition());
        if(goalReached())
            return PositionBinary.getActions(swarm.getBestPosition());

        return Collections.emptyList();

    }

    public void updateGlobalBest(){
        swarm.updateBestPosition();
    }

    public void updateVelocity(){
        swarm.updateVelocity(psoSettings.getW(), psoSettings.getC1(), psoSettings.getC2());
    }

    public void updatePosition(){
        swarm.updatePosition();
    }

    public void fixPosition(){
        swarm.fixPosition(etatInitial);
    }

    public void updateFitness(){
        swarm.updateFitness();
    }

    public void updateBestLocalPosition(){
        swarm.updateLocalPosition();
    }

    public boolean goalReached(){
        return swarm.getBestFitness() == 0;
    }


}
