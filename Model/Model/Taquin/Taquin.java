package Model.Model.Taquin;

import Model.Model.Utility;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Taquin implements Cloneable {
    private long taquin;
    private int caseVideIndex;
    private int size;

    public Taquin(int size) {

        this.size = size;
        this.caseVideIndex = searchCaseIndex(0);
    }

    public Taquin(long taquin, int size) {
        this.taquin = taquin;
        this.size = size;
        this.caseVideIndex = searchCaseIndex(0);
    }

    public Taquin(List<Integer> taquin, int size) {
        this.size = size;
        this.taquin = arrToInt(taquin);
        this.caseVideIndex = searchCaseIndex(0);
    }

    public long getTaquin() {
        return taquin;
    }

    public void setTaquin(long taquin) {
        this.taquin = taquin;
    }

    public int getCaseVideIndex() {
        return caseVideIndex;
    }

    public int getCaseVide() {
        return caseVideIndex;
    }

    public void setCaseVideIndex(int caseVideIndex) {
        this.caseVideIndex = caseVideIndex;
    }

    public int searchCaseIndex(long v) {
        long t = taquin;
        int i = 0;
        while(true){
            long z = t%10;
            if(z == v)
                break;
            t /= 10;
            i++;
        }
        return i;

    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public void change(Pair pair) {
        int caseVide = getCaseVide();
        taquin = changeDigit(taquin, pair.getIndex(), 0);
        taquin = changeDigit(taquin, caseVide, pair.getN());
        caseVideIndex = pair.getIndex();
    }

    public static int changeDigit(long num, int k, int nDigit){
        k = (int) Utility.powerOf10(k);
        double saved = num%k; // Save digits after
        num = num - (num%(k*10)); //Get what's before k
        return ((int) (num + (nDigit*k) + saved));
    }

    public byte[] taquinArr(){
        long t = taquin;
        int n = size*size;
        Stack<Byte> taq = new Stack<>();
        for (int i = 0; i < n; i++) {

            long z = t % 10;
            taq.push((byte) z);

            t /= 10;
        }
        byte[] tB = new byte[n];
        int i = 0;
        while (!taq.empty())
            tB[i++] = taq.pop();

        return tB;
    }

    public int arrToInt(List<Integer> arr){
        int p = 1;
        int n = size*size;
        int t = 0;
        for(int i = n-1; i > -1; i--){
            t += p*arr.get(i);
            p *= 10;
        }

        return t;
    }

    public void afficherTaquin() {
        long t = taquin;
        int n = size*size;
        Stack<String> taq = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(i%size == 0)
                taq.push("\n");
            long z = t % 10;
            taq.push(z+"\t");

            t /= 10;
        }
        while (!taq.empty()){
            System.out.print(taq.pop());
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taquin taquin1 = (Taquin) o;
        return this.taquin == taquin1.taquin;
    }

    @Override
    public int hashCode() {

        int result = (int) taquin % 362897;
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Taquin taquin = (Taquin) super.clone();
        taquin.setTaquin(this.taquin);
        return taquin;
    }




    @Override
    public String toString() {
        return taquin+"\n";
    }

    public static boolean isValid(String str) {
        List<Integer> t = Arrays.asList(1,0,2,3,4,5,6,7,8);
        for(Integer i:t){
            if(str.indexOf(String.valueOf(i))==-1){
                System.out.println("i "+i);
                return false;
            }
        }
        return true;
    }
}
