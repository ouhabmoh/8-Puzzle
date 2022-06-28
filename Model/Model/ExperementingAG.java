package Model.Model;

import Model.Model.Experementing.GeneratingTestingSet;
import Model.Model.GA.AG;
import Model.Model.GA.Chromosome;
import Model.Model.GA.GaSettings;
import Model.Model.GA.RunnerAG;
import Model.Model.Recherche.A;
import Model.Model.Recherche.Heuristique.Manhatten;
import Model.Model.Recherche.Recherche;
import Model.Model.Taquin.InitEtat;
import Model.Model.Taquin.Taquin;

import java.util.ArrayList;
import java.util.List;

public class ExperementingAG {
    private int[] population = {15,20,30,40};
    private int[] maxGeneration = {2500, 5_000,10_000,15_000};
    private double[] mutation = {0.1,0.5,1};

    private double[] crossover = {0.5,0.7,0.9,1};
    private int[] maxUnchanged = {250, 500,1_000,1500,2_000};

    private int numberOfTry = 5;

    private List<GaSettings> gaSettingsList;

    private List<Taquin> taquins;
    private Taquin taquinFinal = InitEtat.getEtatFinalNormale();



    public void setUpGaSettings(){
        gaSettingsList = new ArrayList<>(calculNumber());
        for(int i = 0; i < population.length; i++){
            for(int j = 0; j < maxGeneration.length; j++){
                for(int k = 0; k < mutation.length; k++){
                    for(int l = 0; l < crossover.length; l++){
                        for(int z = 0; z < maxUnchanged.length; z++){
                            GaSettings gaSettings = new GaSettings(3,3,population[i], maxGeneration[j], mutation[k], crossover[l], maxUnchanged[z]);
                            gaSettingsList.add(gaSettings);
                        }
                    }

                }
            }
        }

    }

    public void loadData(){
        GeneratingTestingSet generatingTestingSet = new GeneratingTestingSet(50);
        generatingTestingSet.generate();
      //  taquins = generatingTestingSet.getTaquinList().stream().toList();

    }

    public List<TestingSet> runExperements(){
        List<TestingSet> testingSetList = new ArrayList<>(calculNumber());
        int taquinSize = taquins.size();
        for(GaSettings gaSettings:gaSettingsList){
            int success = 0;
            int optimal = 0;
            double tempsTotal = 0;
            for(Taquin taquin:taquins){

                for(int i = 0; i < numberOfTry; i++){

                    AG ag = new AG(taquin, taquinFinal, gaSettings);
                    RunnerAG runnerAG = new RunnerAG(ag, gaSettings.getMaxUnchanged());
                    double temps = TimeTest.testTime(runnerAG);
                    tempsTotal += temps;
                    Chromosome chromosome = runnerAG.getSolution();
                    if(chromosome != null){
                        success++;
                        int solutionSize = chromosome.getNbAction();
                        Recherche recherche = new A(taquin, taquinFinal, new Manhatten());
                        recherche.run();
                        if(recherche.getSolution().size() == solutionSize)
                            optimal++;
                    }
                }


            }

            double succesRate = (double) success/(taquinSize*numberOfTry);
            double optimalRate = (double) optimal/(taquinSize*numberOfTry);
            double temps =  tempsTotal/(taquinSize*numberOfTry) ;
            TestingSet testingSet = new TestingSet(gaSettings, succesRate, optimalRate, temps);
            SaveTestingSetResults.save(testingSet);
            testingSetList.add(testingSet);
        }

        return testingSetList;
    }

    private int calculNumber(){
        return population.length*maxGeneration.length*mutation.length*crossover.length*maxUnchanged.length;
    }
}
