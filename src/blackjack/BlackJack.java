package blackjack;

import java.util.Scanner;


public class BlackJack {
    
    static Game game = new Game();
        
    public static void ChoiceOfPlayers(GUI gui) {
        Scanner in = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++) {
              String S = "";
            while(!S.toLowerCase().equals("stand")) {
                System.out.println("Player Number " + (i+1) + " { " + game.players[i].name + " } " + " ( Hit Or Stand ) ? ");
                S = in.next();
                if(S.toLowerCase().equals("hit")) {
                    Card arr = game.DrowDeck();
                    game.players[i].addCard(arr);
                    gui.updatePlayerHand(arr, i);
                }    
           }   
        }
    }
             
    public static void ChoiceOfDealer(GUI gui) {
        boolean dealerWin = true;    // Suppose Dealer won
        int highscore = 0;
        for (int i = 0; i < 3; i++) {
            if(game.highScoreOfGame[i] >= game.players[3].score) {
                dealerWin = false;
            }
            if(game.highScoreOfGame[i] > highscore) {
              highscore = game.highScoreOfGame[i];  
            }
        }
        if(!dealerWin) {
           while(game.players[3].score < highscore) {
           Card arr = game.DrowDeck();
           game.players[3].addCard(arr);
           gui.updateDealerHand(arr, game.cards);
        }
        }
        else {
            return;
        }
    }
     
    public static void theWinnerIntheGame() {        // Check Who Is win in The Game
        int highscore = 0,  playerwin = -1;
        for (int i = 0; i < 4; i++) {
            if(game.highScoreOfGame[i] > highscore) {
                highscore = game.highScoreOfGame[i];
                playerwin = i;
            }
        }
        if(playerwin >= 0) {
            System.out.println("********#***********#************#************");
            System.out.println("********#***********#************#************");
            System.out.println("The Player Who Win Is " + game.players[playerwin].name);
            System.out.println("His Score Is : " + highscore);
        }
        else {
            System.out.println("PUSH");
        }
    }
  
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        
        game.GenerateCards();
        
        game.DisplayInfo();

        gui.runGUI(game.cards, game.players[0].getThe_hand(), game.players[1].getThe_hand(), game.players[2].getThe_hand(), game.players[3].getThe_hand());
     
        ChoiceOfPlayers(gui); 

        game.TheScoreOfGame();
        
        ChoiceOfDealer(gui); 

        game.TheScoreOfGame();
        
       theWinnerIntheGame();
        
    }
        
} 