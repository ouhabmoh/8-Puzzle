package Model.Model.Recherche.Heuristique;


import Model.Model.Recherche.Noeud;
import Model.Model.Taquin.Taquin;

public class MisPlaced extends Heuristique{
    @Override
    public int evaluate(Noeud noeud, Taquin etatBut) {


        return evaluate(noeud.getTaquin(), etatBut);
    }

    public int evaluate(Taquin etatInitial, Taquin etatBut) {

        long t = etatInitial.getTaquin();
        long t2 = etatBut.getTaquin();
        int n = etatInitial.getSize() * etatInitial.getSize();
        int casesMalPlacer = 0;

        for (int i = 0; i < n; i++) {
            long z = t % 10;
            long z2 = t2%10;
            if(z != 0 && z != z2)
                casesMalPlacer++;
            t /= 10;
            t2 /= 10;
        }

        return casesMalPlacer;
    }
}
