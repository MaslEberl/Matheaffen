package at.htl.wels;

public class LevelVier {
    // Level 4: dividieren 1-50

    private static boolean levelGeschafft = false;
    private static int maxRechnungen=20;
    Rechnungen rechnen=new Rechnungen();

    public void levelVierDividieren(){
        levelGeschafft=  rechnen.dividieren(maxRechnungen);
        if(levelGeschafft) {
            System.out.println("\nDas Level wurde erfolgreich beendet! Gut gemacht");
        } else
            System.out.println("\nLeider nicht geschafft! Viel Erfolg beim nächsten Mal!");
    }

    public boolean methodeIstTrue(){
        return levelGeschafft;
    }
}