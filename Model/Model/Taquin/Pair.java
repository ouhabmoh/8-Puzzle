package Model.Model.Taquin;

import java.util.Objects;

public class Pair { //tile and its position
    private int n;
    private int index;

    public Pair(int n, int index) {
        this.n = n;
        this.index = index;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return n == pair.n &&
                index == pair.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, index);
    }
}
