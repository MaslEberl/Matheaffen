package at.htl.wels;

public class Main {

    public static void main(String[] args) {

        int i=0;
        int maxRechnungen = 20;
        int[] zufallsZahlen = new int[maxRechnungen];

        while(i<maxRechnungen) {
            zufallsZahlen[i] = (int) (Math.random() * 10) + 1;
            System.out.println();
        }
    }
}
