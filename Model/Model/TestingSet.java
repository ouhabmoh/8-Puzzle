package Model.Model;

import Model.Model.GA.GaSettings;

public class TestingSet {
    private GaSettings gaSettings;
    private double successRate;
    private double optimalRate;

    private double timeMilli;

    public TestingSet(GaSettings gaSettings, double successRate, double optimalRate, double timeMilli) {
        this.gaSettings = gaSettings;
        this.successRate = successRate;
        this.optimalRate = optimalRate;
        this.timeMilli = timeMilli;
    }

    public GaSettings getGaSettings() {
        return gaSettings;
    }

    public void setGaSettings(GaSettings gaSettings) {
        this.gaSettings = gaSettings;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public double getOptimalRate() {
        return optimalRate;
    }

    public void setOptimalRate(double optimalRate) {
        this.optimalRate = optimalRate;
    }

    public double getTimeMilli() {
        return timeMilli;
    }

    public void setTimeMilli(double timeMilli) {
        this.timeMilli = timeMilli;
    }
}
