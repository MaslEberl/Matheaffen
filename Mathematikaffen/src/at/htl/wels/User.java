package at.htl.wels;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable{
    private String username;
    private String passwort;
    private boolean levelEins;
    private boolean levelZwei;
    private boolean levelDrei;
    private boolean levelVier;

    LevelEins eins = new LevelEins();
    LevelZwei zwei = new LevelZwei();
    LevelDrei drei = new LevelDrei();
    LevelVier vier = new LevelVier();

    private ArrayList<User> userData = new ArrayList<>();


    public User(String username, String passwort, boolean levelEins, boolean levelZwei, boolean levelDrei, boolean levelVier) {
        this.username = username;
        this.passwort = passwort;
        this.levelEins = levelEins;
        this.levelZwei = levelZwei;
        this.levelDrei = levelDrei;
        this.levelVier = levelVier;
    }


    //anlegen eines neuen Benutzers
    public String[] addUser() throws IOException {
        userData=load();
        String username;
        String passwort;
        String[] userDataTemp= new String[3];
        userDataTemp[2]="true";

        System.out.println("Neuen Benutzer anlegen!\n");

        //Username und Passwort mit Hilfe der Methode userLoginData
        userDataTemp=userLoginData();
        username=userDataTemp[0];
        passwort=userDataTemp[1];

        userData.add(new User(username,passwort,false,false,false,false));

        save(userData);
        return userDataTemp;
    }

    public String[] searchUser() throws IOException {
        //es lädt die CSV, um alle vorhandenen User zu überprüfen
        userData = load();
        String usernameSearch;
        String passwortSearch;
        String[] userDataTemp = new String[3];
        boolean userLogin = true;
        String[] usernamePasswordArray = new String[100];
        int usernameIndex = 0;
        int passwordIndex = 1;
        int loginVersuch = 0;

        //mit Hilfe der Methode werden aus den Usern in der CSV-Datei nur der Username und das Passwort ausgelesen
        usernamePasswordArray = loadUsernamePasswordFromCSV();
        userDataTemp = userLoginData();
        usernameSearch = userDataTemp[0];
        passwortSearch = userDataTemp[1];

        //Solange kein Passender Login gefunden wurde, wird der Nächste "User" überprüft
            while (userLogin) {
                //Solange das Array nicht leer ist, wird überprüft ob ...
                if(usernamePasswordArray[usernameIndex]!=null){

                //... der Username übereinstimmt
                if (usernameSearch.compareTo(usernamePasswordArray[usernameIndex]) == 0) {

                    //Wenn der Username gefunden wurde, wird das Passwort überprüft
                    if (passwortSearch.compareTo(usernamePasswordArray[passwordIndex]) == 0) {

                        //sind die Logindaten richtig, wird der User eingeloggt
                        System.out.println("Login");
                        userLogin=false;
                        userDataTemp[2]="true";
                    }
                }
                usernameIndex = usernameIndex + 2;
                passwordIndex = passwordIndex + 2;
            } else{
                    //wurde das Array ohne treffer durchlaufen, wird der User erneut aufgefordert die Logindaten einzugeben!
                    //dies geschieht über die Main.java
                    System.out.println("Username oder Passwort ist falsch!\n");
                    userLogin=false;
                    userDataTemp[2]="false";
                }
        }

        return userDataTemp;
    }


    public static String[] userLoginData(){
        String usernameSearch;
        String passwortSearch;
        Scanner sc = new Scanner(System.in);
        String[] s = new String[3];

        //Username und Passwort müssen eigegeben werden
        System.out.println("Username: ");
        usernameSearch = sc.next();
        System.out.println("\nPasswort: ");
        passwortSearch = sc.next();

        //Array zum übergeben wird befüllt
        s[0]=usernameSearch;
        s[1]=passwortSearch;

        return s;
    }

    private static String[] loadUsernamePasswordFromCSV(){
        String[] s = new String[100];
        String[] usernamePasswordArray = new String[100];
        int username=0;
        int password=1;
        String line;

        //CSV wird Zeile für Zeile eingelesen und bei ";" getrennt
        try (BufferedReader reader = new BufferedReader(new FileReader("UserData.csv"))) {
            while ((line = reader.readLine()) != null) {
                s = line.split(";");
                //Das Array, mit den Usernames bzw Passwörtern wird befüllt
                usernamePasswordArray[username]=s[0];
                usernamePasswordArray[password]=s[1];

                //Die Laufvariablen "username" und "passwort" werden jeweils um 2 erhöht,
                //da, das Array nich überschrieben werden sollen und somit alles Usernames bzw Passwörter
                //aus der CSV in ein einziges Array gespeichert werden
                username=username+2;
                password=password+2;
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }

        return usernamePasswordArray;
    }

    private static void save(ArrayList<User> users) {
        //Arraylist mit den Usern wird in eine CSV gespeichert
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("UserData.csv"));
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
        String fileContent = "";
        for (User u : users) {
            fileContent = fileContent + u.toString() + "\n";
        }
        try {
            writer.write(fileContent);
            writer.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    private static ArrayList<User> load() {
        String[] s = new String[100];
        String line;
        ArrayList<User> tempList=new ArrayList<>();

        //die Arraylist wird aus der UserData.csv eingelesen um so bei jedem Start die jeden User wieder abzuspeichern und nicht
        //nur den letzten User wie am Anfang
        try (BufferedReader reader = new BufferedReader(new FileReader("UserData.csv"))){

            while((line=reader.readLine())!=null) {

                s = line.split(";");
                tempList.add(new User(s[0], s[1], Boolean.valueOf(s[2]), Boolean.valueOf(s[3]), Boolean.valueOf(s[4]), Boolean.valueOf(s[5])));
            }

        } catch (IOException ex) {
            System.err.println(ex.toString());
        }

        return tempList;
    }

     public void updateUser(String currentUsername, String currentPassword){

        String[] s = new String[100];
        String line;
        boolean levelEinsWert;
         boolean levelZweiWert;
         boolean levelDreiWert;
         boolean levelVierWert;
        ArrayList<User> tempList = new ArrayList<>();
        //die Arraylist wird aus der UserData.csv eingelesen um so bei jedem Start die jeden User wieder abzuspeichern und nicht
         // nur den letzten User wie am Anfang
         try (BufferedReader reader = new BufferedReader(new FileReader("UserData.csv"))){
             while((line=reader.readLine())!=null) {
                 s = line.split(";");
                 levelEinsWert=Boolean.valueOf(s[2]);
                 levelZweiWert=Boolean.valueOf(s[3]);
                 levelDreiWert=Boolean.valueOf(s[4]);
                 levelVierWert=Boolean.valueOf(s[5]);

                 if(!levelEinsWert){
                     levelEinsWert=eins.methodeIstTrue();
                 }

                 if(!levelZweiWert){
                     levelZweiWert=zwei.methodeIstTrue();
                 }

                 if(!levelDreiWert){
                     levelDreiWert=drei.methodeIstTrue();
                 }

                 if(!levelVierWert){
                     levelVierWert=vier.methodeIstTrue();
                 }

                 if(((s[0].compareTo(currentUsername)==0))&&(s[1].compareTo(currentPassword))==0){
                     tempList.add(new User(currentUsername,currentPassword,levelEinsWert,levelZweiWert,levelDreiWert,levelVierWert));
                     }else{
                     tempList.add(new User(s[0], s[1], Boolean.valueOf(s[2]), Boolean.valueOf(s[3]), Boolean.valueOf(s[4]), Boolean.valueOf(s[5])));
                     }
             }

             } catch (IOException ex) {
             System.err.println(ex.toString());
             }

             save(tempList);
    }

    //Getter / Setter der Variablen
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public boolean isLevelEins() {
        return levelEins;
    }

    public void setLevelEins(boolean levelEins) {
        this.levelEins = levelEins;
    }

    public boolean isLevelZwei() {
        return levelZwei;
    }

    public void setLevelZwei(boolean levelZwei) {
        this.levelZwei = levelZwei;
    }

    public boolean isLevelDrei() {
        return levelDrei;
    }

    public void setLevelDrei(boolean levelDrei) {
        this.levelDrei = levelDrei;
    }

    public boolean isLevelVier() {
        return levelVier;
    }

    public void setLevelVier(boolean levelVier) {
        this.levelVier = levelVier;
    }

    @Override
    public String toString() {
        return username+";"+ passwort +";"+levelEins+";"+ levelZwei +";" + levelDrei + ";" + levelVier;
    }
}
