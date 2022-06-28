package Model.Model.PSO;

public class PSOSettings {
    private int nbPopulation;

    private int maxIterations;
    private double w;
    private double c1;
    private double c2;
    private double maxVelocity;

    private int nbAction;


    public PSOSettings(int nbPopulation, int maxIterations, double w, double c1, double c2, double maxVelocity, int nbAction) {
        this.nbPopulation = nbPopulation;
        this.maxIterations = maxIterations;
        this.w = w;
        this.c1 = c1;
        this.c2 = c2;
        this.maxVelocity = maxVelocity;
        this.nbAction = nbAction;
    }

    public int getNbPopulation() {
        return nbPopulation;
    }

    public void setNbPopulation(int nbPopulation) {
        this.nbPopulation = nbPopulation;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getC1() {
        return c1;
    }

    public void setC1(double c1) {
        this.c1 = c1;
    }

    public double getC2() {
        return c2;
    }

    public void setC2(double c2) {
        this.c2 = c2;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public void setMaxVelocity(double maxVelocity) {
        this.maxVelocity = maxVelocity;
    }

    public int getNbAction() {
        return nbAction;
    }

    public void setNbAction(int nbAction) {
        this.nbAction = nbAction;
    }
}
