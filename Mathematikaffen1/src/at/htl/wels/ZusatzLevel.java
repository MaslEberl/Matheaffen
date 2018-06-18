package at.htl.wels;

public class ZusatzLevel {
    //Level Zusatzlevel: addieren/subdrahieren/multipizieren/dividieren 1-100
    public static int maxRechnungen = 30;
    public int maxLevel=4;
    public  int rechenart=0;

    public void levelZusatz(int[] zahlen){
        rechenart = (int) (Math.random() * maxLevel) + 1;


       if(rechenart==1){

       }else if(rechenart==2){

       }else if(rechenart==3){

       }else if(rechenart==4){

       }
    }
}
