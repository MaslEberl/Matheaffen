package at.htl.wels;

public class LevelVier {
    // Level 4: dividieren 1-50

    private boolean levelGeschafft = false;
    private static int maxRechnungen=20;
    Rechnungen rechnen=new Rechnungen();

    public void levelVierDividieren(int[] zahlen){
        levelGeschafft=  rechnen.dividieren(zahlen,maxRechnungen);
        if(levelGeschafft) {
            System.out.println("\nDas Level wurde erfolgreich beendet! Gut gemacht");
        } else
            System.out.println("\nLeider nicht geschafft! Viel Erfolg beim nächsten Mal!");
    }

    public boolean methodeIstTrue(){
        return levelGeschafft;
    }
}
