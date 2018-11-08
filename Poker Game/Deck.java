import java.util.*;

public class Deck
{
   public static int SIZE = 52;

   private Card[] cards;
   private Random rand;

   public Deck()
   {
	   rand = new Random();
	   cards = new Card[SIZE];
	   for (int i = Card.DIAMONDS; i <= Card.SPADES; i++)
         for (int j = 2; j <= 14; j++)
             cards[(i-1)*13 + (j-2)] = new Card(i, j);
   }

   public void shuffle()
   {
	   System.out.println("Welcome!");
	   System.out.println("Shuffling started...");
	   Collections.shuffle(Arrays.asList(cards));
	   //Use Collections.shuffle to shuffle the cards,this function requires Array List
	   System.out.println("Shuffling finished");
   }
   
   public Card[] getRandomCard()
   {
	   Card[] RandomCard = new Card[1];
	   RandomCard[1] = cards[1];
	   //Since we shuffled the cards in the last step, get the 1st card as a random choice
	   return RandomCard;
   }
   
   public Card[] getRandomFiveCards()
   {
	   System.out.println("Dealing started...");
	   Card[] RandomFiveCards = new Card[5];
	   for(int i = 0; i < 5; i++)
	   {
		   RandomFiveCards[i] = cards[i];
		   //We already shuffled the cards, get the 1st to 5th cards as 5 random cards
	   }
	   System.out.println("Dealing finished");
	   return RandomFiveCards;
   }
   
   public String toString()
   {
	   for(Card k : cards) {
	   System.out.println(k.toString() + ",");
	   }
	   //Use for loop to print the representation of the deck.
	   return " ";
   }
}
//I'm a little confused that I didn't use rand in this program, so what is thar for?
//I think this can be used for the method getRandomCard() to return a random choice.