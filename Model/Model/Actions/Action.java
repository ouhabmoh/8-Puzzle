package Model.Model.Actions;

import Model.Model.Taquin.Index;
import Model.Model.Taquin.Pair;
import Model.Model.Taquin.Taquin;
import Model.Model.Utility;

import java.util.Objects;

public abstract class Action {
    protected String binaryCode;
    protected int v;

    public void action(Taquin taquin){
        taquin.change(getPairNeighbour(taquin));
    }


    public abstract boolean isActionValide(Taquin taquin);


    public int getV() {
        return v;
    }

    public boolean eq(Action action) {
        return v == -action.getV();
    }

    public Pair getPairNeighbour(Taquin taquin){
        int i = getNeighbourPosition(taquin);
        long t = taquin.getTaquin();

        double k = Utility.powerOf10(i);
        int x = (int) ((t/k)%10);
        return new Pair(x,i);
    }

    public abstract int getNeighbourPosition(Taquin taquin);
    public abstract Action getInverseAction();
    public abstract Character getChar();

    public String getBinaryCode() {
        return binaryCode;
    }

    public void setBinaryCode(String binaryCode) {
        this.binaryCode = binaryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return getV() == action.getV();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getV());
    }
}
