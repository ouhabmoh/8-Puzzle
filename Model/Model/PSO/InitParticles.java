package Model.Model.PSO;

import Model.Model.Actions.*;
import Model.Model.Taquin.Taquin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InitParticles {

    private static List<Action> actions = Arrays.asList(new Up(), new Down(), new Left(), new Right());

    public static Particle initParticle(Taquin etatInitial, int nbAction, double velocity){
        List<Action> actions = new ArrayList<>(nbAction);
        Taquin taquin;
        try {
            taquin = (Taquin) etatInitial.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        Particle particle = new Particle(taquin);
        Action action = getRandomValidAction(particle);
        particle.ajouterAction(action);

        for(int i = 1; i < nbAction; i++){
            Action actionChoisi = getRandomValidAction(particle);

            particle.ajouterAction(actionChoisi);

        }

        long position = Math.abs(PositionBinary.getPosition(particle.getActions()));
        particle.setPosition(position);
        particle.setVelocity(velocity);
        FitnessFunction.evaluate(particle);



        return particle;
    }


    public static void fixParticle(Particle particle, Taquin etatInitial){

        List<Action> actions = particle.getActions();

        Taquin taquin;
        try {
            taquin = (Taquin) etatInitial.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        particle.setEtat(taquin);
        particle.setSolution(new ArrayList<>());

        for(Action action:actions){

            if(particle.isActionValide(action))
                particle.ajouterAction(action);
            else{
                Action actionChoisi = getRandomValidAction(particle);

                particle.ajouterAction(actionChoisi);
            }
        }
    }

    public static Action getRandomValidAction(Particle particle){
        Action actionChoisi;
        while(true){
            Random random = new Random();
            int randomAction = random.nextInt(4);
            actionChoisi = actions.get(randomAction);

            if(particle.isActionValide(actionChoisi))
                break;
        }
        return actionChoisi;
    }

}
