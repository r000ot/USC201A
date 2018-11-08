/**********************************************************
 * HW 1: Playing Poker
 *
 *
 * Name:
 *
 **********************************************************/

import java.util.*;

public class MainDriver
{
   public static void main(String[] args)
   {
      Deck deck = new Deck();
      
      deck.shuffle();
      //shuffle the cards

      //display a deck
      System.out.println("\nDeck:\n");
      System.out.println(deck);

      // draw a hand (five random cards)
      Card[] hand = deck.getRandomFiveCards();

      System.out.println("\nRandom Hand:\n");
		for(int i = 0; i < 5; i++)
			System.out.println(hand[i]);
		//print the five random cards in hands

		System.out.println();

      PokerHand p = new PokerHand(hand);
      System.out.println("\nEVALUATION: " + p.evaluate());
      //print the evaluation results
   }
}
