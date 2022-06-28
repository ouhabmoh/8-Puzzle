package Model.Model.Actions;

import Model.Model.Taquin.Taquin;

public class Down extends Action {
    public Down() {
        binaryCode = "01";
        v = -1;
    }


    public int getNeighbourPosition(Taquin taquin){
        int i = taquin.getCaseVide()-taquin.getSize();
        return i;
    }
    public Action getInverseAction(){
        return new Up();
    }

    @Override
    public Character getChar() {
        return 'b';
    }

    @Override
    public boolean isActionValide(Taquin taquin) {
        int videIndex = taquin.getCaseVide();
        int n = taquin.getSize();
        return videIndex/n != 0;//102345678
    }

    @Override
    public String toString() {
        return "Down";
    }
}
