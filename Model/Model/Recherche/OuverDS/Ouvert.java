package Model.Model.Recherche.OuverDS;


import Model.Model.Recherche.Noeud;

public interface Ouvert {
    boolean isEmpty();

    void add(Noeud noeud);

    Noeud remove();

    boolean remove(Noeud noeud);

    boolean contain(Noeud noeud);

    void clear();

    int size();
}
