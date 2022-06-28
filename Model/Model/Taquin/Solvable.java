package Model.Model.Taquin;

public class Solvable {
    private final int n;

    public Solvable(int n) {
        this.n = n;
    }

    public int getInvCount(byte[] arr) {

        int inv_count = 0;
        int s = n*n;
        for (int i = 0; i < s - 1; i++){
            if(arr[i] == 0)
                continue;

            for (int j = i + 1; j < s; j++) {

                if (arr[j] > 0 && arr[j] < arr[i])
                    inv_count++;
            }
        }

        return inv_count;
    }


    public boolean isSolvable(Taquin taquin) {

        int invCount = getInvCount(taquin.taquinArr());

        // if n is odd check inv if is even
        if (n % 2 != 0)
            return invCount % 2 == 0;

        // else n is even check for casevide index
        int caseVide = taquin.getCaseVide() / n +1;

        if (caseVide % 2 == 0)
            return invCount % 2 == 1;
        else
            return invCount % 2 == 0;


    }

    public boolean isSolvable(Taquin taquinInitial, Taquin taquinBut){
        boolean b1 = isSolvable(taquinInitial);
        boolean b2 = isSolvable(taquinBut);
        if((b1 && b2) || (!b1 && !b2))
            return true;

        return false;
    }

}
