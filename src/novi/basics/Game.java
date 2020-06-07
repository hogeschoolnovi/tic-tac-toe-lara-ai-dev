package novi.basics;

import static novi.basics.Main.PLAYERINPUT;

public class Game {

    private Field[] board;
    private int maxRounds;
    private boolean winner;

    private Player player1;
    private Player player2;
    private Player activePlayer;

    private int drawCount;
    private int chosenIndex;





    public Game(Player player1, Player player2){
        // keuze
        // speelbord opslaan ( 1 - 9 )
       //board = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        board = new Field[9];

        for (int fieldIndex = 0; fieldIndex < 9 ; fieldIndex++) {
            board[fieldIndex] = new Field(fieldIndex + 1);

        }
        // maximale anntal rondes opslaan
        maxRounds = board.length;

        this.player1 = player1;
        this.player2 = player2;

        drawCount = 0;
        activePlayer = player1;

    }
    public void play()  {



        // -- opnieuw het spel spelen met dezelfde spelers (op het eind na keuze 1)



        // speelbord tonen
        printBoard();

        // token van de actieve speler opslaan
        //char activePlayerToken = 'X';


        boolean isMiddle = true;
        while (isMiddle) {

            // starten  met de beurt  ( maximaal 9 beurten)

            for (int round = 0; round < maxRounds; round++) {

                    // naam van de actieve speler opslaan

                    String activePlayerName = activePlayer.getName();

                    // actieve speler vragen om een veld te kiezen ( 1 - 9 )
                    System.out.println(activePlayerName + ", please choose a field");


                    // gekozen veld van de actieve speler  opslaan
                    int chosenField = PLAYERINPUT.nextInt();
                    chosenIndex = chosenField - 1;

                    //int chosenIndex =
                    // chosenField - 1;


                    // als het veld bestaat :
                    if (chosenIndex < 9 && chosenIndex >= 0) {



                        //als het veld leeg is, wanneer er geen token staat
                        if (board[chosenIndex].isEmpty()) {

                            //wanneer de speler een token op het board geplaatst heeft

                            // de token van de actieve speler op het gekozen veld plaatsen
                            board[chosenIndex].setToken(activePlayer.getToken());
                            board [chosenIndex].setChosenIndex(board[chosenIndex].getChosenIndex());

                            // het nieuwe speelbord tonen
                            printBoard();

                            // als het spel gewonnen is -- niet goed
                            if (checkForWinner() == 1) {
                                System.out.println("It's a tie");
                            } else if(checkForWinner() == 2){
                                System.out.println(activePlayer + "wins");
                                activePlayer.addScore();
                            }


                            // tonen wie gewonnen heeft (de actieve speler)
                            // de actieve speler krijgt een punt
                            // de scores van de speler tonen

                            // wanneer we in de laatse beurt zijn en nieumand gewonnen heeft
                            // opslaan dat het gelijk spel is
                            // aantal keer gelijk spel tonen

                            // de beurt doorgegeven aan de volgende speler (van speler wisselen)
                            // als de actieve speler, speler 1 is:

                            //changePlayer();
                            if (activePlayer == player1) {
                                //maak de actieve speler, speler 2
                                activePlayer = player2;
                            }
                            // anders
                            else {
                                // maak de acteve speler weer speler 1
                                activePlayer = player1;
                            }


                        }//of al bezet is:
                        else {
                            maxRounds++;
                            System.out.println("this field is not available, choose another!");
                        }


                    }
                    // als het veld niet bestaat
                    else {
                        // het maximale aantal beurten verhogen
                        maxRounds++;
                        // fout melding tonen aan de speler
                        System.out.println("the chosen field does not exist, try again!");
                    }




            }
        }

    }





    public int checkForWinner() {


        //check horizontal wins
        for (int i = 0; i <= 6; i += 3) {
            if (board[i] == board[chosenIndex] && board[i + 1] == board[chosenIndex] && board[i + 2] == board[chosenIndex]) {
                return 2;
            }

        }
        //check for vertical wins
        for (int i = 0; i <= 2 ; i++) {
            if(board[i] == board[chosenIndex] && board[i + 3] == board[chosenIndex] && board[i+ 6] == board [chosenIndex]){
                return 2;
            }


        }
        //check for diagonal wins
        if((board[0] == board[chosenIndex] && board[4] == board[chosenIndex] && board[8] == board[chosenIndex])
        || (board[2] == board[chosenIndex] && board[4] ==  board[chosenIndex] && board[6] == board[chosenIndex])){
            return 2;
        }

        // check for tie
        for (int i = 0; i < board.length; i++) {
            //if we find a number, then noone has won yet
            if(board[i] != board[chosenIndex]);
            return 0;
        }

    return 1;

    }




    public void printBoard() {
        for (int fieldIndex = 0; fieldIndex < board.length; fieldIndex++) {
            System.out.print(board[fieldIndex].getToken() + " ");

            // als we het tweeede veld geprint hebben of het vijfde veld geprint hebben
            // dan gaan we naar de volgende regel
            if (fieldIndex == 2 || fieldIndex == 5) {
                System.out.println();
            }

        }
        System.out.println();

    }
}

