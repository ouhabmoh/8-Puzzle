package Model.Model.Recherche;


import Model.Model.Actions.Action;
import Model.Model.Recherche.OuverDS.QueueO;
import Model.Model.Taquin.Taquin;

import java.util.Collections;
import java.util.List;

public class BFS extends Recherche{
    public BFS(Taquin etatInitial, Taquin but) {
        super(etatInitial, but);
        ouvert = new QueueO();
    }

    @Override
    public List<Action> run() {


        ouvert.add(root);
        fermer.put(root.getTaquin(),root);
        while (!ouvert.isEmpty()) {

            Noeud noeud = ouvert.remove();
            updateProfondeur(noeud.getProfondeur());

            nDeveloper++;

            for (Action action : getValidActions(noeud)) {
                Noeud newNoeud = createNoeud(noeud, action);
                if (isGoal(newNoeud))
                    return trackSolution(newNoeud);

                if (fermer.containsKey(newNoeud.getTaquin()))
                    continue;

                ouvert.add(newNoeud);
                fermer.put(newNoeud.getTaquin(),newNoeud);
                nGenerer++;
            }
        }

        return Collections.emptyList();
    }

}
