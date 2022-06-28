package Model.Model.Actions;

import Model.Model.Taquin.Taquin;

public class ActionVide extends Action {

    public ActionVide() {
        v = 0;
    }



    @Override
    public int getNeighbourPosition(Taquin taquin) {
        return -1;
    }

    @Override
    public Action getInverseAction() {
        return new ActionVide();
    }

    @Override
    public Character getChar() {
        return null;
    }

    @Override
    public boolean isActionValide(Taquin taquin) {
        return false;
    }
}
