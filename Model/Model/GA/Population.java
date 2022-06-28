package Model.Model.GA;

import Model.Model.Taquin.Taquin;

import java.util.ArrayList;
import java.util.List;

public class Population {
    private List<Chromosome> chromosomes = new ArrayList<>();
    private double averageFitness;
    private double worstFitness;
    private double bestFitness;
    private Chromosome bestCh;

    public Population(Taquin etatInitial, int nbCh, int nbAct) {
        for(int i = 0; i < nbCh; i++){
                Chromosome chromosome = GenererChromosome.generer(etatInitial,nbAct);
                FitnessFunction.evaluate(chromosome);
                chromosomes.add(chromosome);
        }

    }

    public boolean ajouterChromosome(Chromosome chromosome){
        return chromosomes.add(chromosome);
    }

    public boolean supprimerChromosome(Chromosome chromosome){
        return chromosomes.remove(chromosome);
    }

    public List<Chromosome> getChromosomes() {
        return chromosomes;
    }

    public void calculatePopFitness() {
        double best = 1000;
        double average = 0;
        double worst = -1;
        for (Chromosome chromosome : chromosomes) {
            if (chromosome.getFitnessScore() < best){
                best = chromosome.getFitnessScore();
                bestCh = chromosome;
            }

            if (chromosome.getFitnessScore() > worst)
                worst = chromosome.getFitnessScore();

            average += chromosome.getFitnessScore();
        }

        bestFitness = best;
        averageFitness = average / chromosomes.size();
        worstFitness = worst;
    }

    public double getAverageFitness() {
        return averageFitness;
    }

    public double getWorstFitness() {
        return worstFitness;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public Chromosome getBest() {
        return bestCh;
    }
}
