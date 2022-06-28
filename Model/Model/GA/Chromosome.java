package Model.Model.GA;



import Model.Model.Actions.Action;
import Model.Model.Actions.ActionVide;
import Model.Model.Taquin.Taquin;

import java.util.ArrayList;
import java.util.List;

public class Chromosome {
    private List<Action> actions = new ArrayList<>();
    private Taquin taquinBut;
    double fitnessScore;

    public Chromosome(Taquin taquinBut) {
        try {
            this.taquinBut = (Taquin) taquinBut.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Chromosome(List<Action> actions, Taquin taquinBut) {
        this.actions = actions;
        this.taquinBut = taquinBut;
    }

    public boolean ajouterActions(Action action){
        if (action.isActionValide(taquinBut)){
            action.action(taquinBut);
            return actions.add(action);

        }


        return false;
    }

    public boolean ajouterAction(Action action){
        action.action(taquinBut);

        return actions.add(action);
    }


    public boolean isActionValide(Action action){


        return action.isActionValide(taquinBut) && !action.eq(getLastAction());
    }

    public Action getAction(int index){
        return actions.get(index);
    }

    public Taquin appliquerActions(){
        for(Action action:actions)
            action.action(taquinBut);
        return taquinBut;
    }

    public List<Action> getActions() {
        return actions;
    }

    public Action getLastAction(){
        if(actions.size() == 0)
            return new ActionVide();

        return actions.get(actions.size()-1);
    }

    public Taquin getTaquinBut() {
        return taquinBut;
    }

    public int getNbAction(){
        return actions.size();
    }

    public double getFitnessScore() {
        return fitnessScore;
    }

    public void setFitnessScore(double fitnessScore) {
        this.fitnessScore = fitnessScore;
    }

    @Override
    public String toString() {
        return "actions=" + actions;
        }
}
