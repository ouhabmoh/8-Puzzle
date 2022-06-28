package Model.Model.Recherche;


import Model.Model.Actions.Action;

import Model.Model.Recherche.OuverDS.StackOv;
import Model.Model.Taquin.Taquin;

import java.util.Collections;
import java.util.List;

public class Profondeur extends Recherche {
    private int maxProfondeur = -1;

    public Profondeur(Taquin etatInitial, Taquin but) {
        super(etatInitial, but);
        ouvert = new StackOv();
    }

    public Profondeur(Taquin etatInitial, Taquin but, int maxProfondeur) {
        super(etatInitial, but);
        this.maxProfondeur = maxProfondeur;
        ouvert = new StackOv();
    }

    public List<Action> run() {


        ouvert.add(root);
        while (!ouvert.isEmpty()) {

            Noeud noeud = ouvert.remove();
            updateProfondeur(noeud.getProfondeur());

            if (fermer.containsKey(noeud.getTaquin()))
                continue;

            if (isGoal(noeud)) {
//                System.out.println(noeud.getProfondeur());
                return trackSolution(noeud);
            }

            fermer.put(noeud.getTaquin(), noeud);

            if (profondeur == maxProfondeur)
                continue;





            for (Action action : getValidActions(noeud)) {
                Noeud newNoeud = createNoeud(noeud, action);
                ouvert.add(newNoeud);
            }
        }

        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "DFS";
    }
}
