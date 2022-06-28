package Model.Model.GA;

public class GaSettings {
    private int tour_size;
    private int tourRemoveSize;
    private int popluation_size;
    private int maxGenerations;

    private double mutationRate;

    private double crossoverRate;

    private int maxUnchanged;

    public GaSettings() {
    }

    public GaSettings(int tour_size, int tourRemoveSize, int popluation_size, int maxGenerations) {
        this.tour_size = tour_size;
        this.tourRemoveSize = tourRemoveSize;
        this.popluation_size = popluation_size;
        this.maxGenerations = maxGenerations;
    }

    public GaSettings(int tour_size, int tourRemoveSize, int popluation_size, int maxGenerations, double mutationRate, double crossoverRate, int maxUnchanged) {
        this(tour_size, tourRemoveSize, popluation_size, maxGenerations);
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.maxUnchanged = maxUnchanged;
    }

    public int getTour_size() {
        return tour_size;
    }

    public void setTour_size(int tour_size) {
        this.tour_size = tour_size;
    }

    public int getTourRemoveSize() {
        return tourRemoveSize;
    }

    public void setTourRemoveSize(int tourRemoveSize) {
        this.tourRemoveSize = tourRemoveSize;
    }

    public int getPopluation_size() {
        return popluation_size;
    }

    public void setPopluation_size(int popluation_size) {
        this.popluation_size = popluation_size;
    }

    public int getMaxGenerations() {
        return maxGenerations;
    }

    public void setMaxGenerations(int maxGenerations) {
        this.maxGenerations = maxGenerations;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }

    public int getMaxUnchanged() {
        return maxUnchanged;
    }

    public void setMaxUnchanged(int maxUnchanged) {
        this.maxUnchanged = maxUnchanged;
    }
}
