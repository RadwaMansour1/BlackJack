package blackjack;

class Player {
    public String name; 
    public int score = 0;  
    private Card[] the_hand = new Card[11];
    private int cont = 0;
    
    public void addCard(Card arr) { 
        if(cont < 11) {
            the_hand[cont] = arr;
            cont++;
            score += arr.getValue();
        }
    }
 
    public Card[] getThe_hand() {
        return the_hand;
    }
    
  
}
