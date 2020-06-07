package novi.basics;

import java.util.Scanner;

public class Main {
    public static Scanner PLAYERINPUT = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isBeginning = true;
        while (isBeginning) {



            // -- opnieuw spelers aanmaken na het eind van het spel bij keuze 2
            // de 1e speler om zijn naam vragen
            System.out.println("Player 1 what is your name ?");
            // de naam van de 1e speler opslaan
            String player1Name = PLAYERINPUT.next();
            Player player1 = new Player(player1Name, 'X');

            // de 2e speler om zijn naam vragen
            System.out.println("Player 2 what is your name ?");
            // de naam van de 2e speler opslaan
            String player2Name = PLAYERINPUT.next();
            Player player2 = new Player(player2Name, 'O');

            boolean isMiddle = true;
            while (isMiddle) {

                Game game = new Game(player1, player2);
                game.play();
            }

            // vragen of de spelers nog een keer willen spelen
            System.out.println("Want to play another round?, choose: ");
            // 1: nog een keer spelen
            System.out.println("1: Play again");
            // 2: van spelers wisselen
            System.out.println("2: Change players");
            // 3: aflsuiten
            System.out.println("3: Terminate the game");

            // speler keuze opslaan
            int playerchoice = PLAYERINPUT.nextInt();
            // bij keuze 1: terug naar het maken van het bord
            if (playerchoice == 1) {
                isMiddle = false;
            }// bij keuze 2: terug naar de start van de applicatie en het vragen van speler namen
            if (playerchoice == 2) {
                isBeginning = false;
            }// bij keuze 3: het spel en de applicatie helemaal afsluiten
            if (playerchoice == 3) {
                break;
            }
        }





    }



}
