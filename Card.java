//Jeffrey Carino

public class Card{
    public final static int SPADES = 0;  
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
   
    public final static int ACE = 1;     
    public final static int JACK = 11;   
    public final static int QUEEN = 12;  
    public final static int KING = 13;
    
    private final int suit;
    private final int value;
    public boolean visible;
    
    //Default Constructor
    public Card(){
	suit = 1;
	value = 1;
    }

    //This Method creates a card with the a specified suit and value.
    public Card(int theValue, int theSuit){
	value = theValue;
	suit = theSuit;
	visible = false;
    }

    public int getSuit(){
	return suit;
    }

    public int getValue(){
	return value;
    }
    
    public String getSuitString(){
	switch(suit){
	case SPADES:   
	    return "S";
	case HEARTS:   
	    return "H";
	case DIAMONDS: 
	    return "D";
	case CLUBS:   
	    return "C";
	default:    
	    return "";
	}
    }
    
    public String getValueString(){
	switch(value){
	case 1:  
	    return "Ace";
	case 2:
	    return "2";
	case 3:
	    return "3";
	case 4:
	    return "4";
	case 5:
	    return "5";
	case 6:
	    return "6";
	case 7:
	    return "7";
	case 8:
	    return "8";
	case 9:
	    return "9";
	case 10:
	    return "10";
	case 11:
	    return "Jack";
	case 12:
	    return "Queen";
	default:
	    return "King";
	}
    }
    
    public void makeVisible(){
	visible = true;
    }
    
    public void makeInvisible(){
	visible = false;
    }

    public boolean Visible(){
	return visible;
    }
    
    public String toString(){
	if(visible == false){
	    return "OO";
	}else{
	    return getValueString() + getSuitString();
	}
    }

}