package Model.Model.GA;

import Model.Model.Actions.Action;
import Model.Model.Taquin.Taquin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class AG {

    private Taquin etatInitial;
    Population population;
    private GaSettings gaSettings;
    private int nbAction;
    public AG(Taquin etatInitial, Taquin etatFinal, GaSettings gaSettings) {
        this.etatInitial = etatInitial;
        FitnessFunction.setEtatFinale(etatFinal);
        nbAction = (int) (FitnessFunction.distance(etatInitial) * 1.1);
        population = new Population(etatInitial, gaSettings.getPopluation_size(),nbAction);
        this.gaSettings = gaSettings;

    }



    public void applyGeneticOp(){
        Random random = new Random();
        if(random.nextInt(100) < gaSettings.getCrossoverRate()*100){
            Chromosome selectedCH1 = selection();
            Chromosome selectedCH2 = selection();
            crossover(selectedCH1, selectedCH2);
        }
        if(random.nextInt(100) < gaSettings.getMutationRate()*100)
            mutation();
    }

    public Chromosome selection(){
        return tourSelectionByBest();
    }

    public void updatePopulation(){
        doubleNbAction();
        population = new Population(etatInitial,gaSettings.getPopluation_size(),nbAction);
    }

    public void updatePopulation2(){

        GenererChromosome.addActionToChromosomes(population);
        FitnessFunction.evaluate(population);
        nbAction++;
    }

    public void crossover(Chromosome selectedCH1, Chromosome selectedCH2){
        Chromosome chromosome = new Chromosome(etatInitial);
        int minAction = selectedCH1.getNbAction() < selectedCH2.getNbAction() ? selectedCH1.getNbAction() : selectedCH2.getNbAction();
        Action action = null;
        for(int i = 0; i < minAction; i++){
            Random rn = new Random();
            if(rn.nextInt(10) < 5){

                if(chromosome.isActionValide(selectedCH1.getAction(i)))
                    action = selectedCH1.getAction(i);
                else
                    action = GenererChromosome.getRandomValidAction(chromosome);

            }else{
                if(chromosome.isActionValide(selectedCH2.getAction(i)))
                    action = selectedCH2.getAction(i);
                else
                    action = GenererChromosome.getRandomValidAction(chromosome);

            }
            chromosome.ajouterAction(action);

        }

        FitnessFunction.evaluate(chromosome);
        population.ajouterChromosome(chromosome);
        population.supprimerChromosome(removeByTourSelection());
//        System.out.println();
//        System.out.println("parent 1 "+selectedCH1.getFitnessScore()+" nbAction:"+selectedCH1.getNbAction());
//        System.out.println("parent 2 "+selectedCH2.getFitnessScore()+" nbAction:"+selectedCH2.getNbAction());
//        System.out.println("fils "+chromosome.getFitnessScore()+" nbAction:"+chromosome.getNbAction());
//        System.out.println();
    }

    public void mutation(){
        Random random = new Random();
        int indexCh = random.nextInt(gaSettings.getPopluation_size());
        Chromosome chromosome = population.getChromosomes().get(indexCh);
        Chromosome chromosomeMutated = new Chromosome(etatInitial);
        int nbAction = chromosome.getNbAction();
        int indexAction = random.nextInt(nbAction);
        for(int i = 0; i < indexAction; i ++){
            chromosomeMutated.ajouterAction(chromosome.getActions().get(i));
        }

        for(int i = indexAction; i < nbAction; i++){
            Action action = GenererChromosome.getRandomValidAction(chromosomeMutated);
            chromosomeMutated.ajouterAction(action);
        }
        FitnessFunction.evaluate(chromosomeMutated);
        population.getChromosomes().set(indexCh,chromosomeMutated);


    }


    public Chromosome removeByTourSelection() {
        List<Chromosome> tour = touSelection(gaSettings.getTourRemoveSize());

        return tour.get(gaSettings.getTour_size() - 1);
    }

    public Chromosome tourSelectionByBest() {

        List<Chromosome> tour = touSelection(gaSettings.getTour_size());

        return tour.get(0);
    }

    private List<Chromosome> touSelection(int tour_size) {
        List<Chromosome> tour = new ArrayList<>(tour_size);
        int i = 0;
        int populationSize = gaSettings.getPopluation_size();
        while (i < tour_size) {
            Random rn = new Random();
            int id1 = rn.nextInt(populationSize);
            tour.add(population.getChromosomes().get(id1));
            i++;
        }
        tour.sort(Comparator.comparingDouble(Chromosome::getFitnessScore));
        return tour;
    }


    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    public GaSettings getGaSettings() {
        return gaSettings;
    }

    public void setGaSettings(GaSettings gaSettings) {
        this.gaSettings = gaSettings;
    }

    public int getNbAction() {
        return nbAction;
    }

    public void doubleNbAction(){
        nbAction += 1;
    }
}
