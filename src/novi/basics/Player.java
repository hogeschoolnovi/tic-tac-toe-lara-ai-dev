package novi.basics;

public class Player {

    //attributen: informatie verzamelen > alle informatie dat te maken heeft met de speler
    // attributen alle private
    private String name;
    private char token;
    private int score;
    private String activePlayerName;




    //methode: acties die de speler uit kan voeren
    //constrcutor > methode dat de speler classe gaat aanmaken & this refereerd aan de aatribute & zwarte aan de parameter > alleen wat voor de spelers ander zijn

    public Player (String name, char token){
        this.name = name;
        this.token = token;
        score = 0;
    }

    //get methoden
    public String getName (){
        return name;
    }

    public char getToken(){
        return token;
    }

    public int getScore(){
        return score;
    }


    //set methoden - nieuwe score

    public void addScore(){
        score++;
    }

    public void activePlayerName(String activePlayerName){
        this.name = activePlayerName;
    }





}
