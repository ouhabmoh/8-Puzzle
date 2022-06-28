package Model.Model.Actions;

import Model.Model.Taquin.Taquin;

public class Up extends Action {
    public Up() {
        binaryCode = "00";
        v = 1;
    }



    public int getNeighbourPosition(Taquin taquin){
        //123405678
        int i = taquin.getCaseVide()+taquin.getSize();
        return i;
    }
    public Action getInverseAction(){
        return new Down();
    }

    @Override
    public Character getChar() {
        return 'h';
    }

    @Override
    public boolean isActionValide(Taquin taquin) {
        int videIndex = taquin.getCaseVide();
        int n = taquin.getSize();
        return videIndex/n != (n-1);
    }

    @Override
    public String toString() {
        return "Up";
    }
}
