public class Card
{
   public final static int DIAMONDS = 1;
   public final static int CLUBS = 2;
   public final static int HEARTS = 3;
   public final static int SPADES = 4;

   public final static int TEN = 10;
   public final static int JACK = 11;
   public final static int QUEEN = 12;
   public final static int KING = 13;
   public final static int ACE = 14;

   private int suit;
   private int value;

   public Card(int suit, int value)
   {
      if (isValidValue(value) && isValidSuit(suit))
      {
         this.value = value;
         this.suit = suit;
      }
      else
      {
         //Error
      }
   }

   public int getSuit()
   {
      return suit;
   }

   public int getValue()
   {
      return value;
   }

   public boolean isValidValue(int value)
   {
     return (value >= 2 && value <= ACE);
   }
   public boolean isValidSuit(int suit)
   {
     return (suit >= DIAMONDS && suit <= SPADES);
   }

   private static String valueToString(int number)
   {
      String result = "";
      switch (number)
      {
      case 2:     result = "Two";   break;
      case 3:     result = "Three"; break;
      case 4:     result = "Four";  break;
      case 5:     result = "Five";  break;
      case 6:     result = "Six";   break;
      case 7:     result = "Seven"; break;
      case 8:     result = "Eight"; break;
      case 9:     result = "Nine";  break;
      case TEN:   result = "Ten";   break;
      case JACK:  result = "Jack";  break;
      case QUEEN: result = "Queen"; break;
      case KING:  result = "King";  break;
      case ACE:   result = "Ace";   break;
      default:    result = "no value";  break;
      }
      return result;
   }

   private String suitToString(int suit)
   {
      String result = "";
      switch (suit)
      {
         case DIAMONDS:  result = "Diamonds";  break;
         case CLUBS:     result = "Clubs";     break;
         case HEARTS:    result = "Hearts";    break;
         case SPADES:    result = "Spades";    break;
         default:        result = "none";      break;
      }
      return result;
   }

   public String toString()
   {
      return valueToString(value) + " of " + suitToString(suit);
   }
}
