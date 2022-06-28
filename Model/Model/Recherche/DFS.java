package Model.Model.Recherche;


import Model.Model.Actions.Action;
import Model.Model.Recherche.Heuristique.Heuristique;
import Model.Model.Recherche.Heuristique.Manhatten;
import Model.Model.Recherche.OuverDS.StackOv;
import Model.Model.Taquin.Taquin;

import java.util.Collections;
import java.util.List;

public class DFS extends Recherche{
    private int seuil;
    public DFS(Taquin etatInitial, Taquin but, int maxD) {
        super(etatInitial, but);
        ouvert = new StackOv();
        if(maxD > 0){
            this.seuil = maxD;
        }else{
            Heuristique man = new Manhatten();
            this.seuil = 2 * man.evaluate(new Noeud(etatInitial), but);
        }

    }


    @Override
    public List<Action> run() {


        ouvert.add(root);

        while (!ouvert.isEmpty()) {

            Noeud noeud = ouvert.remove();
            updateProfondeur(noeud.getProfondeur());
            nDeveloper++;
            if (isGoal(noeud))
                return trackSolution(noeud);
            if(profondeur > seuil)
                continue;

            if(isCycle(noeud))
                continue;

            for (Action action : getValidActions(noeud)) {
                Noeud newNoeud = createNoeud(noeud, action);

                if (fermer.containsKey(newNoeud.getTaquin()))
                    continue;

                ouvert.add(newNoeud);
                nGenerer++;

            }
        }

        return Collections.emptyList();
    }

    private boolean isCycle(Noeud noeud){
        Noeud n = noeud;
        boolean isCycle = false;
        int i = 0;
        while (n != null && i < 4) {
            i++;
            n = n.getPere();
        }
        while (n != null) {
            if(noeud.equals(n)){
                isCycle = true;
                break;
            }

            n = n.getPere();
        }
        return isCycle;
    }
}
