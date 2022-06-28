package Model.Model.GA;

import Model.Model.Taquin.Taquin;

public class FitnessFunction {

    private static int[] etatFinaleIndexes;

    public static double distance(Taquin etat){
        long t = etat.getTaquin();
        int s = etat.getSize();
        int n = s * s;
        int distances = 0;


        for (int i = 0; i < n; i++) {
            int z = (int) (t % 10);
            t /= 10;
            if(z == 0)
                continue;
            int indexbut = etatFinaleIndexes[z];
            int X1 = getX(n-i-1,s);
            int X2 = getX(n-indexbut-1,s);
            int Y1 = getY(n-i-1,s);
            int Y2 = getY(n-indexbut-1,s);
            distances += Math.abs(X1 - X2) + Math.abs(Y1-Y2);

        }

        return distances;
    }

    public static void setEtatFinale(Taquin etatFinal){
        int n = etatFinal.getSize() * etatFinal.getSize();
        etatFinaleIndexes = new int[n];
        long t = etatFinal.getTaquin();
        for (int i = 0; i < n; i++) {

            int z = (int) (t % 10);
            etatFinaleIndexes[z] = i;

            t /= 10;

        }

    }

    private static int getX(int index, int n){
        return index/n;
    }

    private static int getY(int index, int n){
        return index%n;
    }
    public static void evaluate(Chromosome chromosome){
        double f = distance(chromosome.getTaquinBut());
//        chromosome.getTaquinBut().afficherTaquin();
//        Main.etatFinal.afficherTaquin();
//        System.out.println(f);
//        System.out.println();
        chromosome.setFitnessScore(f);


    }

    public static void evaluate(Population population){
        for(Chromosome chromosome:population.getChromosomes()){
            evaluate(chromosome);
        }
    }
}
