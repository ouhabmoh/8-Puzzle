package Model.Model;

public class Utility {

    private static double[] powersOf10 = {1.0, 10.0, 100.0, 1000.0, 10000.0, 100000.0, 1000000.0, 1.0E7, 1.0E8};
    public static double powerOf10(int n){
        return powersOf10[n];
    }

}
