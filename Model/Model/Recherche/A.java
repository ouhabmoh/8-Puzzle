package Model.Model.Recherche;

import Model.Model.Actions.Action;
import Model.Model.Recherche.Heuristique.Heuristique;
import Model.Model.Recherche.OuverDS.Priority;

import Model.Model.Taquin.Taquin;

import java.util.Collections;
import java.util.List;
public class A extends Recherche {

    Heuristique heuristique;

    public A(Taquin etatInitial, Taquin but, Heuristique heuristique) {
        super(etatInitial, but);
        this.heuristique = heuristique;
        ouvert = new Priority();
    }

    public List<Action> run() {


        ouvert.add(root);
        fermer.put(root.getTaquin(),root);
        while (!ouvert.isEmpty()) {

            Noeud noeud = ouvert.remove();
            updateProfondeur(noeud.getProfondeur());

            nDeveloper++;
            if (isGoal(noeud))
                return trackSolution(noeud);



            for (Action action : getValidActions(noeud)) {
                Noeud newNoeud = createNoeud(noeud, action);
                if(!fermer.containsKey(newNoeud.getTaquin())){
                    ouvert.add(newNoeud);
                    fermer.put(newNoeud.getTaquin(),newNoeud);
                    nGenerer++;
                }

            }
        }

        return Collections.emptyList();
    }


    @Override
    public Noeud createNoeud(Noeud pere, Action action) {

        Noeud noeud = super.createNoeud(pere, action);
        evaluate(noeud);
        return noeud;

    }

    public void evaluate(Noeud noeud) {
        int score = noeud.getProfondeur() + heuristique.evaluate(noeud, but);
        noeud.setScore(score);
    }

    @Override
    public String toString() {
        return "A*";
    }
}
