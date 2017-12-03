import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck 
{	
			public ArrayList<Card> usedCard = new ArrayList<Card>();
			private ArrayList<Card> openCard;
			public int nUsed;
	        int ndeck;
			private ArrayList<Card> cards;
			public Deck(int nDeck)
			{
				ndeck=nDeck;
				usedCard= new ArrayList<Card>();
				openCard= new ArrayList<Card>();
				cards=new ArrayList<Card>();
				 for (int j=1;j<=nDeck;j++)
				 {
					 for (int k=1;k<=4;k++)
					 {
						 for (int l=1;l<=13;l++)
						 {
							if (k==1)//Order every card at this cards arrayList 
							{
							 Card card=new Card(Card.Suit.Clubs,l);		
									 cards.add(card);
							}
							if (k==2)
							{
							 Card card=new Card(Card.Suit.Diamonds,l);		
									 cards.add(card);
							}
							if (k==3)
							{	
							 Card card=new Card(Card.Suit.Hearts,l);		
									 cards.add(card);
							}
							if (k==4)
							{
							 Card card=new Card(Card.Suit.Spades,l);		
									 cards.add(card);
							}
						 }
					 }
				 }
				 shuffle();
			}	
			public void printDeck()
			{
		         for (int n=0;n<cards.size();n++)
				     {
					 cards.get(n).printCard();
				     }                                  
			}
			public ArrayList<Card> getAllCards()
			{
				return cards;
			}
			public void shuffle() 
		    {
		    	for (int i =0;i<nUsed;i++)//get one card in arraycards.Put this card into usedCard.
		    	{
		    	cards.add(usedCard.get(i));
		    	}
		    	for (int i=0;i<999;i++)
		    	{
		    		Random rnd = new Random();
			    	int a = rnd.nextInt(cards.size());//get random position "a". 
		    		Card temp=cards.get(a);//put the card of position "a" in temp.
		    		cards.remove(cards.get(a));//remove arraycards position.
		    		cards.add(temp);//put what card in the temp into array cards. 
		    	}
		    	nUsed=0;
		    	usedCard.clear();
		    	openCard.clear();
		    }
		    public Card getOneCard(boolean isOpened)
		    {
		    	
		    	if (nUsed==ndeck*52)//if all the cards are used then shuffle.
		    	{
		    		shuffle();
		    		if(isOpened)
		    		{
		    			openCard.add(cards.get(nUsed));//用過的加在打開的裡面
		    		}
		    	}
		    	Card temp=cards.get(0); //get the first card in the array cards. 
		    	cards.remove(0);
		    	usedCard.add(temp);
		    	nUsed+=1;
		    	return temp;
		    }
		    public ArrayList<Card> getOpenedCard()
		    {
		    	return openCard;
		    }
}



