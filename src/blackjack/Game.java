package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public Player[] players = new Player[4];
    public Card[] cards = new Card[52]; 
    public int[] highScoreOfGame = new int[4];       // The HighScore For 4 Players
    
    public void GenerateCards() {
        int value, index = 0; 
        for(int i=0; i<4; i++) {        // i => suit
            for(int j=0; j<13; j++) {       // j => rank
             if(j > 9) {
                value = 10;
             }
             else {
                value = j+1;
             }
                Card card = new Card(i, j, value);
                cards[index] = card;
                index++;
            }
        }
    }
           
    public Card DrowDeck() {
        Random rand = new Random();
        Card theCard = null ; 
        while(theCard == null) { 
          int randomChoice = rand.nextInt(51);  
          theCard = cards[randomChoice];
          cards[randomChoice] = null;
        }
       return theCard;
    }
           
    public void DisplayInfo() { 
     Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter The Name Of Player Number " + (i+1) + " : ");
            players[i] = new Player();
            players[i].name = in.next();
            for (int j = 0; j < 2; j++) {     // to give 2 cards to each player at the beginning of the game 
              players[i].addCard(DrowDeck());
            }
        }
            players[3] = new Player();
            players[3].name = "Dealer";
            for (int i = 0; i < 2; i++) {
              players[3].addCard(DrowDeck());
        }
    }
  
    public void TheScoreOfGame() {
        for (int i = 0; i < highScoreOfGame.length; i++) {
            if(highScoreOfGame[i] <= 21) {
                highScoreOfGame[i] = players[i].score;
            }
            else {
                highScoreOfGame[i] = 0;
            }
        }
    }
    
}
 
