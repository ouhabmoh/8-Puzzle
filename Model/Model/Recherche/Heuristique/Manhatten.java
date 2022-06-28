package Model.Model.Recherche.Heuristique;


import Model.Model.Recherche.Noeud;
import Model.Model.Taquin.Taquin;

public class Manhatten extends Heuristique {
    @Override
    public int evaluate(Noeud noeud, Taquin etatBut) {

        long t = noeud.getTaquin().getTaquin();
        int s = noeud.getTaquin().getSize();
        int n = s * s;
        int distances = 0;

        for (int i = 0; i < n; i++) {
            long z = t % 10;
            t /= 10;
            if(z == 0)
                continue;
            int indexbut = etatBut.searchCaseIndex(z);
            int X1 = getX(n-i-1,s);
            int X2 = getX(n-indexbut-1,s);
            int Y1 = getY(n-i-1,s);
            int Y2 = getY(n-indexbut-1,s);
            distances += Math.abs(X1 - X2) + Math.abs(Y1-Y2);

        }

        return distances;
    }

    private int getX(int index, int n){
        return index/n;
    }

    private int getY(int index, int n){
        return index%n;
    }
}
