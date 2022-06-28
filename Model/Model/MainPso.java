package Model.Model;

import Model.Model.Actions.Action;
import Model.Model.PSO.FitnessFunction;
import Model.Model.PSO.PSO2;
import Model.Model.PSO.PSOSettings;
import Model.Model.Recherche.A;
import Model.Model.Recherche.Heuristique.Manhatten;
import Model.Model.Recherche.Recherche;
import Model.Model.Taquin.InitEtat;
import Model.Model.Taquin.Taquin;

import java.util.List;

public class MainPso {
    private static int n = 3;
    public static Taquin etatInitial;
    public static Taquin etatFinal;

    public static void main(String[] args) throws CloneNotSupportedException {

        etatInitial =  InitEtat.getEtatI();
        etatInitial.afficherTaquin();

        etatFinal = InitEtat.getEtatF();
        etatFinal.afficherTaquin();
        Recherche recherche = new A(etatInitial,etatFinal,new Manhatten());
        recherche.run();
        System.out.println(recherche.getSolution());

        FitnessFunction.setEtatFinale(etatFinal);
        int nbAction = (int) (2*FitnessFunction.distance(etatInitial));
        PSOSettings psoSettings = new PSOSettings(100, 100000, 1.5, 2 , 3, 5, nbAction);


        PSO2 pso2 = new PSO2(etatInitial, psoSettings);
        List<Action> actions = pso2.run();
        System.out.println(actions);
        System.out.println(actions.size());
    }
}
