package Model.Model.Actions;

import Model.Model.Taquin.Taquin;

public class Left extends Action {
    public Left() {
        binaryCode = "10";
        v = -2;
    }



    public int getNeighbourPosition(Taquin taquin){
        //123405678
        int i = taquin.getCaseVide()+1;
        return i;
    }

    @Override
    public Action getInverseAction() {
        return new Right();
    }

    @Override
    public Character getChar() {
        return 'g';
    }


    @Override
    public boolean isActionValide(Taquin taquin) {
        int videIndex = taquin.getCaseVide();
        int n = taquin.getSize();
        return videIndex%n != (n-1);
    }

    @Override
    public String toString() {
        return "Left";
    }
}
