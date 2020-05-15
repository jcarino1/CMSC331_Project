//Jeffrey Carino

public class Deck{

    private Card[] deck;
    int PrevCard;
    int CurrCard;

    public Deck(){
	deck = new Card[52];

	int cardCt = 0; // How many cards have been created so far.
        for(int suit = 0; suit <= 3; suit++) {
            for(int value = 1; value <= 13; value++){
                deck[cardCt] = new Card(value,suit);
                cardCt++;
            }
        }
    }
    
    public boolean won(){
	int occupied = 0;

	for(int i = 0; i <deck.length; i++){
	    if(deck[i].toString() == "OO"){
		occupied++;
	    }
	}
	if(occupied == 0){
	    return true;
	}else{
	    return false;
	}
    }

    public boolean Found(int k){
	if(deck[k].Visible() == true){
	    return true;
	}
	return false;
    }
    
    public boolean FoundAlready(int j, int k){
	if(deck[j].Visible() == true || deck[k].Visible() == true){
	    return true;
	}
	return false;
    }
    
    public boolean isEmpty(){
	int k = 0;
	
	while(k < deck.length){
	    if(deck[k].toString() == "OO"){
		return false;
	    }
	    k++;
	}
	return true;
    }
    
    public boolean Check(){
	if(deck[PrevCard].getValue() == deck[CurrCard].getValue()){
	    if(deck[PrevCard].getSuitString() == "H"  && deck[CurrCard].getSuitString() == "D" || deck[PrevCard].getSuitString() == "D"  && deck[CurrCard].getSuitString() == "H"){
		System.out.println("Congrats! You matched the cards " + deck[PrevCard].toString() + " and " + deck[CurrCard].toString() + "!");
		return true;	
	    }else if(deck[PrevCard].getSuitString() == "S"  && deck[CurrCard].getSuitString() == "C" || deck[PrevCard].getSuitString() == "C"  && deck[CurrCard].getSuitString() == "S"){
		System.out.println("Congrats! You matched the cards " + deck[PrevCard].toString() + " and " + deck[CurrCard].toString() + "!");
		return true;
	    }
	}
	
	deck[PrevCard].makeInvisible();
	deck[CurrCard].makeInvisible();
	return false;
    }

    public int size(){
	return deck.length;
    }

    public void RemoveCard(int j, int k){
	System.out.println(j);
	System.out.println(k);
	deck[j].makeVisible();
	deck[k].makeVisible();
	PrevCard = j;
	CurrCard = k;
    }
    public void print(){
	int k = 0;

	for(int i = 0; i < 4; i++){
	    for(int j = 0; j < 13; j++){
		System.out.print(deck[k].toString() + " ");
		k++;
	    }
	    System.out.println();
	}
    }
}    