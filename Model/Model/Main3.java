package Model.Model;

import Model.Model.Experementing.Experementing;

public class Main3 {
    public static void main(String[] args) {
        ExperementingAG experementingAG = new ExperementingAG();
        experementingAG.setUpGaSettings();
        experementingAG.loadData();
        experementingAG.runExperements();
    }
}
