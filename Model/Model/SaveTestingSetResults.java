package Model.Model;

import java.io.FileWriter;
import java.io.IOException;

public class SaveTestingSetResults {
    public static void save(TestingSet testingSet){
        try (FileWriter out = new FileWriter("result.csv", true)) {

            out.write(testingSet.getGaSettings().getPopluation_size() + ",");
            out.write(testingSet.getGaSettings().getMaxGenerations() + ",");
            out.write(testingSet.getGaSettings().getMutationRate() + ",");
            out.write(testingSet.getGaSettings().getCrossoverRate() + ",");
            out.write(testingSet.getGaSettings().getMaxUnchanged() + ",");
            out.write(testingSet.getSuccessRate()+ ",");
            out.write(testingSet.getOptimalRate()+ ",");
            out.write(testingSet.getTimeMilli()+ ",");


            out.write("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
