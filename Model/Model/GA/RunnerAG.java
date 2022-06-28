package Model.Model.GA;

import Model.Model.Experementing.Runnable;

public class RunnerAG implements Runnable {
    private AG ag;
    private int maxUnchanged;

    private Chromosome solution;
    public RunnerAG(AG ag, int maxUnchanged) {
        this.ag = ag;
        this.maxUnchanged = maxUnchanged;
    }


    public Chromosome run(){
        int nbGenerations = 0;
        int nbGenerationsUnchanged = 0;
        double oldBest = 10000;
        Population population = ag.getPopulation();;
        int maxGeneration = ag.getGaSettings().getMaxGenerations();
        while (nbGenerations < maxGeneration) {
            population.calculatePopFitness();

//            System.out.println(nbGenerations);
//            System.out.println(population.getBestFitness() + " " + population.getAverageFitness() + " " + population.getWorstFitness());
            if(population.getBestFitness() == 0)
                solution = population.getBest();


            if(oldBest >= population.getBestFitness()){
                nbGenerationsUnchanged++;
            }else if(population.getBestFitness() < oldBest){
                oldBest = population.getBestFitness();
                nbGenerationsUnchanged = 0;
            }
            if(nbGenerationsUnchanged > maxUnchanged) {
                oldBest = 10000;
                nbGenerationsUnchanged = 0;

                ag.updatePopulation2();
            }
            ag.applyGeneticOp();




            nbGenerations++;
        }

        return solution;
    }

    @Override
    public void reset() {

    }

    public Chromosome getSolution() {
        return solution;
    }

    public void setSolution(Chromosome solution) {
        this.solution = solution;
    }

    public void saveStatistics(){

    }

    public AG getAg() {
        return ag;
    }

    public void setAg(AG ag) {
        this.ag = ag;
    }
}
