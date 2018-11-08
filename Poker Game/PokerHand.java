import java.util.*;

public class PokerHand
{
   final static int SIZE = 5;
   final static int HIGH_CARD = 0;
   final static int PAIR      = 1;
   final static int TWO_PAIRS = 2;
   final static int THREE_KIND= 3;
   final static int STRAIGHT  = 4;
   final static int FLUSH     = 5;
   final static int FULL_HOUSE     = 6;
   final static int FOUR_KIND = 7;
   final static int S_FLUSH   = 8;

   private Card[] hand;

   public PokerHand(Card[] h)
   {
      hand = h;
   }
   
   public String evaluate()
   {
	   String evaluation = " ";
	   //Define a String and initialize, valuate this String with our evaluation and then return to print.
	   
	   //First to evaluate whether the handpoker is Flush.
	   boolean isFlush = false; 
	   Set<Integer> SuitSets = new HashSet<Integer>();
	   //Use HashSet to obtain the number of elements.
       for(int i = 0; i < hand.length; i++)
       {
           SuitSets.add(hand[i].getSuit());
       }
       if(SuitSets.size()==1)
       //Use Sets.size() to returns the number of elements in this set.
       {
           isFlush=true;
           //Only one element in the set → Flush
           //We don't print or value the String here, after evaluate for other card type, value at the same if/else part.         
       }
       
       //Then evaluate whether the handpoker is Straight.
       boolean isStraight = false;
       Set<Integer> ValueSets = new HashSet<Integer>();
       List<Integer> ValueLists = new ArrayList<Integer>();
       //We need to sort the list to determine whether it is straight, so we need the value.
       for(int i = 0; i < hand.length; i++)
       {
           ValueSets.add(hand[i].getValue());
           ValueLists.add(hand[i].getValue());
       }
       Collections.sort(ValueLists);
       //Use Collections.sort function to sort the list into ascending order.
       int range = ValueLists.get(4) - ValueLists.get(0);
       //Obtain the range between largest number and smallest number.
       if(range == 4 && ValueSets.size() == 5)
       {
    	   isStraight= true;
    	   //Each number has a difference for one → Straight
       }
       //Now we can discuss complex results we have evaluated.
       if(isStraight&isFlush)
       {
       evaluation= "Straight Flush";
       //Value the String with the evaluation for random five cards and return this String in the end.
       }
       else if(isFlush)
       {
       evaluation= "Flush";
       }
       else if(isStraight)
       {
       evaluation= "Straight";
       }
       else if(ValueSets.size() == 5)
    	   //These five cards are not straight and have five different values.
       {
       evaluation= "High Card";
       }
       else if(ValueSets.size() == 4)
    	  //These five cards have two cards with the same value.
       {
       evaluation= "Pair";
       }
       else
       {
       Map<Integer,List<Card>> map = new HashMap<Integer,List<Card>>();
       //Use Map to save the value of cards, the order of a map is defined as the order in which the iterators on the map's collection views return their elements.
       //Change from array structure to map structure
      
       		for(int i = 0; i < hand.length; i++)
       		{
       			Card card = hand[i];
       			//Check whether this card exists in the map.
       			if(map.containsKey(card.getValue()))
       			{
       				List<Card> lst = map.get(card.getValue());
       				lst.add(card);
       				//If exists, get the value of the card for the following evaluation.
       			}
       			else
       			{
       				List<Card> lst = new ArrayList<Card>();
       				lst.add(card);
       				map.put(card.getValue(),lst);
       			}

       		}

       		if(map.size() == 2)
       		{
       			//4 same number + 1 or 3 same number + 2 another same number
       			boolean is4ofKind = false;
       			for(Map.Entry<Integer,List<Card>> entry : map.entrySet())
       			{
       				//Make the entry value be a list.
       				if(entry.getValue().size() == 4)
       				{
       					is4ofKind = true;
       					break;
       				}
       			}
       			if(is4ofKind == true)
       			{
       				evaluation= "Four of a Kind";
       			}
       			else
       			{
       				evaluation= "Full House";
       			}
       		}
       		else if(map.size() == 3)
       		{
       			//2 same number + 2 same number + 1 number or 3 same number + 1 number + 1 number
       			boolean is3ofKind = false;
       			for(Map.Entry<Integer,List<Card>> entry : map.entrySet())
       			{
       				if(entry.getValue().size() == 3)
       				{
       					is3ofKind = true;
       					break;
       				}	
       			}
       			if(is3ofKind == true)
       			{
       				evaluation= "Three of a Kind";
       			}
       			else
       			{
       				evaluation= "Two Pair";
       			}
       		}
       }
       return evaluation;
       //return the String data.
   }
}