package Model.Model.Recherche.OuverDS;

import Model.Model.Recherche.Noeud;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackOv implements Ouvert {

    private final Deque<Noeud> ouvert;

    public StackOv() {
        ouvert = new ArrayDeque<>();
    }

    @Override
    public boolean isEmpty() {
        return ouvert.isEmpty();
    }

    @Override
    public void add(Noeud noeud) {
        ouvert.push(noeud);
    }

    @Override
    public boolean contain(Noeud noeud) {
        return ouvert.contains(noeud);
    }

    @Override
    public Noeud remove() {
        return ouvert.pop();
    }

    @Override
    public boolean remove(Noeud noeud) {
        return ouvert.remove(noeud);
    }

    @Override
    public void clear() {
        ouvert.clear();
    }

    @Override
    public int size() {
        return ouvert.size();
    }
}
