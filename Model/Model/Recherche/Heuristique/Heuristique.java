package Model.Model.Recherche.Heuristique;

import Model.Model.Recherche.Noeud;
import Model.Model.Taquin.Taquin;

public abstract class Heuristique {

    public Heuristique() {
    }

    public abstract int evaluate(Noeud noeud, Taquin etatBut);
}
