package Model.Model.GA;

import Model.Model.Actions.*;
import Model.Model.Taquin.Taquin;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenererChromosome {
    private static List<Action> actions = Arrays.asList(new Up(), new Down(), new Left(), new Right());

    public static Chromosome generer(Taquin etatInitial, int nbAction){
        Taquin taquin;
        try {
            taquin = (Taquin) etatInitial.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        Chromosome chromosome = new Chromosome(taquin);

        Action action = getRandomValidAction(chromosome);
        chromosome.ajouterAction(action);

        for(int i = 1; i < nbAction; i++){
            Action actionChoisi = getRandomValidAction(chromosome);

            chromosome.ajouterAction(actionChoisi);

        }



        return chromosome;
    }

    public static Action getRandomValidAction(Chromosome chromosome){
        Action actionChoisi;
        while(true){
            Random random = new Random();
            int randomAction = random.nextInt(4);
            actionChoisi = actions.get(randomAction);

            if(chromosome.isActionValide(actionChoisi))
                break;
        }
        return actionChoisi;
    }

    public static void addActionToChromosomes(Population population){
        for(Chromosome chromosome : population.getChromosomes()){
            Action action = getRandomValidAction(chromosome);
            chromosome.ajouterAction(action);

        }
    }

    public static void addActionToChromosomes(Population population, int nbAction){
        for(Chromosome chromosome : population.getChromosomes()){
            for(int i = 0; i < nbAction; i++){
                Action action = getRandomValidAction(chromosome);
                chromosome.ajouterAction(action);
            }


        }
    }

}
