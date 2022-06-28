package Model.Model.Actions;

import Model.Model.Taquin.Taquin;

public class Right extends Action {
    public Right() {
        binaryCode = "11";
        v = 2;
    }



    public int getNeighbourPosition(Taquin taquin){
        //102345678
        int i = taquin.getCaseVide()-1;
        return i;
    }

    @Override
    public Action getInverseAction() {
        return new Left();
    }

    @Override
    public Character getChar() {
        return 'd';
    }

    @Override
    public boolean isActionValide(Taquin taquin) {
        int videIndex = taquin.getCaseVide();
        int n = taquin.getSize();
        return videIndex % n != 0;
    }
//    @Override
//    public boolean isActionValide(Taquin taquin,Action action) {
//
//        int videIndex = taquin.getCaseVide();
//        int n = taquin.getSize();
//        return videIndex % n != 0;
//    }

    @Override
    public String toString() {
        return "Right";
    }
}
