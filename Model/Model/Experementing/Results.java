package Model.Model.Experementing;


import Model.Model.Actions.Action;
import Model.Model.Recherche.Recherche;
import Model.Model.Taquin.Taquin;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Results {
    private final Taquin taquinInitial;
    private final List<Action> solution;
    private final long time;
    private final int etatDeveloper;
    private final int etatExplorer;
    private final String algo;
    private final double memory;

    public Results(Taquin taquinInitial, List<Action> solution, long time, int etatDeveloper, int etatExplorer, String algo, double memory) {
        this.taquinInitial = taquinInitial;
        this.solution = solution;
        this.time = time;
        this.etatDeveloper = etatDeveloper;
        this.etatExplorer = etatExplorer;
        this.algo = algo;
        this.memory = memory;
    }

    public Results(Recherche recherche, long time, double memory) {
        this.taquinInitial = recherche.getRoot().getTaquin();
        this.solution = recherche.getSolution();
        this.time = time;
        this.etatDeveloper = recherche.getOuvertSize();
        this.etatExplorer = recherche.getFermerSize();
        this.algo = recherche.toString();
        this.memory = memory;
    }

    public void save() {

        try (FileWriter out = new FileWriter("result.txt", true)) {

            out.write(taquinInitial.getTaquin() + "\t");

            out.write(solution.size() + "\t");

            out.write(time + "\t");
            out.write(etatDeveloper + "\t");
            out.write(etatExplorer + "\t");
            out.write(algo + "\t");
            out.write(memory+" \t");
            for (Action action : solution)
                out.write(action.toString() + "\t");
            out.write("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAsCSV(){

    }
}
